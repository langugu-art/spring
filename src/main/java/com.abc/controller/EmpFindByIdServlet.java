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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpFindByIdServlet ", urlPatterns = {"/empbyid"})
public class EmpFindByIdServlet extends HttpServlet {
    ///empbyid" method="post"
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = Integer.parseInt(request.getParameter("empno"));
        IEmpService empService = (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        Emp emp = empService.findById(empno);

        //反馈java模板引擎
        if (emp != null) {
            List<Emp> emps = new ArrayList<Emp>();
            emps.add(emp);
            request.setAttribute("empsFromServer", emps);
            //!!!!!!!!"/emps.jsp"
            //取得一个RequestDispatcher请求分发器对象，它的方法forward(request,response)作用是将请求转发到lemps.jsp，request封装了请求信息，response封装了响应信息。注意是forward方式，这种方式只转发请求，不产生新的request对象。
            request.getRequestDispatcher("/emps.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg", "精确查询失败");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = Integer.parseInt(request.getParameter("empno"));
        IEmpService empService = (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        Emp emp = empService.findById(empno);
        if(emp != null){
            request.setAttribute("emp",emp);
            request.getRequestDispatcher("/updateemp.jsp").forward(request,response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","无此员工信息，修改失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
