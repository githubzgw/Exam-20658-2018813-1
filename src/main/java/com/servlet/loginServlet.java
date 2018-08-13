package com.servlet;

import com.dao.filmDao;
import com.utils.jdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<String> list = new ArrayList<>();
        System.out.println(req.getParameter("username"));
        list.add(req.getParameter("username"));
        jdbcUtil jdbcUtil = new jdbcUtil();
        try {
            jdbcUtil.getConnection();
            List<Map<String, Object>>  list1= jdbcUtil.findResult("select * from customer where first_name = ?", list);
            if(list1.size() > 0){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("username", req.getParameter("username"));
                filmDao filmDao = new filmDao();
                req.setAttribute("filmlist", filmDao.select());
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }else{
                resp.sendRedirect("login.jsp");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
