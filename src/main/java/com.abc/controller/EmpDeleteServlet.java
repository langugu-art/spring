package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.SpringIOC;
import com.abc.dao.entity.Emp;
import com.abc.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmpDeleteServlet",urlPatterns = {"/empdelete"})
public class EmpDeleteServlet extends HttpServlet {
    //<a href="${pageContext.request.contextPath}/empdelete?empno=${emp.empno}"  >删除</a>
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用int的包装类Integer的parseInt()方法，将empno转换为整形
        int empno=Integer.parseInt(request.getParameter("empno"));
        //用getInstance来获取EMP对象
        IEmpService empService= (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        Emp emp=new Emp();
        emp.setEmpno(empno);
        //***
        String msg=empService.delete(emp);
        if (Comm.SUCCESS.equals(msg)){
            //地址重定向(页面跳转)；项目的名字+"/empbypage"
            response.sendRedirect(request.getContextPath()+"/empbypage");
        }else{
            HttpSession session=request.getSession();
            session.setAttribute("errMsg","员工数据删除失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
