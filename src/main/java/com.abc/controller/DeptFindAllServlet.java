package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.dao.entity.Dept;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IDeptService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DeptFindAllServlet ",urlPatterns = {"/deptall"})
public class DeptFindAllServlet extends HttpServlet {
    //url:"http://localhost:8080/deptall",
    //				type:"get",
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            IDeptService deptService= (IDeptService) ServiceFactory.getInstance(Comm.DEPT);
            Res<List<Dept>> res=deptService.findAll();
            PrintWriter out=response.getWriter();
            out.println(JSON.toJSON(res));
            out.close();
    }
}
