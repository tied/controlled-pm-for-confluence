package com.davidkoudela.confluence.controlledpm.cloud.connect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Description: Web Service
 *              Right now it is for testing purposes
 * Copyright (C) 2016 David Koudela
 *
 * @author dkoudela
 * @since 2016-09-30
 */
public class ControlledPMWebServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException
    {
        String appid = httpServletRequest.getParameter("appid");
        String conta = httpServletRequest.getParameter("conta");

        System.out.println("Appid : "+appid);
        System.out.println("Conta : "+conta);

        String contextPath = httpServletRequest.getServletPath();
        if (contextPath.endsWith(".png")) {
            httpServletResponse.setContentType("application/octet-stream;charset=UTF-8");
        } else if (contextPath.endsWith(".xml")) {
            httpServletResponse.setContentType("application/xml");
        } else {
            httpServletResponse.setContentType("text/plain");
        }

        OutputStream out = httpServletResponse.getOutputStream();
        InputStream in = ControlledPMResourceManager.getResourceStream(contextPath);
        try {
            byte[] buffer = new byte[1024]; // Adjust if you want
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        out.close();
        in.close();
    }
}
