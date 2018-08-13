package com.servlet;

import com.dao.filmDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class deleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("执行删除"+req.getParameter("id"));
        List<Object> list = new ArrayList<>();
        list.add(Integer.parseInt(req.getParameter("id").toString()));
        filmDao filmDao = new filmDao();
        filmDao.delete(list);
        req.setAttribute("filmlist", filmDao.select());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }
}
