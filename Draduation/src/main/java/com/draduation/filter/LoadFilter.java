package com.draduation.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoadFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        String sto = (String) session.getAttribute("sto");
        String jobnumber= (String) session.getAttribute("jobnumber");
        boolean issucc= false;
        if(request.getRequestURI().contains("login")||request.getRequestURI().contains("load")){
            filterChain.doFilter(request,servletResponse);
        }else {
            if(request.getRequestURI().contains("student")){
                if(sto==null){
                    request.getRequestDispatcher("./login.html").forward(request,servletResponse);
                }
                issucc=true;
            }else {
                if(jobnumber==null){
                    request.getRequestDispatcher("./login.html").forward(request,servletResponse);
                }
                issucc=true;
            }
            if(issucc){
                filterChain.doFilter(request,servletResponse);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
