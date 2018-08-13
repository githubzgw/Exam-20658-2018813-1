package com.filter;

import com.dao.filmDao;
import com.dao.languageDao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class indexFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter执行了");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletRequest.setCharacterEncoding("UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        String path=httpServletRequest.getRequestURI();
        System.out.println(path);
            HttpSession httpSession = httpServletRequest.getSession();
            System.out.println("session"+httpSession.getAttribute("username"));
            if(httpSession.getAttribute("username") == null){
                servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
            }else{
                    filmDao filmDao = new filmDao();
                    servletRequest.setAttribute("filmlist", filmDao.select());
                    servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
                    filterChain.doFilter(servletRequest, servletResponse);    //放行
            }
    }

    @Override
    public void destroy() {

    }
}
