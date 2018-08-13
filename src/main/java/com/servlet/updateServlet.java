package com.servlet;

import com.dao.filmDao;
import com.dao.languageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class updateServlet extends HttpServlet {
    int id ;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {  //查询到选中ID的值所对应的数据
        id = Integer.parseInt(req.getParameter("id").toString());
        System.out.println(req.getParameter("id").toString());
        languageDao languageDao = new languageDao();
        req.setAttribute("languagelist", languageDao.select());
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Object> list = new ArrayList<>();
        System.out.println(id);
        System.out.println(req.getParameter("title").toString());
        System.out.println(req.getParameter("description").toString());
        System.out.println(req.getParameter("language").toString());
        list.add(req.getParameter("title").toString());
        list.add(req.getParameter("description").toString());
        list.add(req.getParameter("language").toString());
        filmDao filmDao = new filmDao();
        filmDao.update(list,id);
        req.setAttribute("filmlist", filmDao.select());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
