package com.charon.boot.config;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: servlet
 * @author: charon
 * @create: 2020-01-10 15:50
 **/
@WebServlet(name = "firstServlet", urlPatterns = "/first")
@Slf4j
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("servlet");
        response.getWriter().write("firstServlet");
    }
}
