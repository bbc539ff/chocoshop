package com.chocoshop.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

@WebFilter({"/admin/login", "/admin/register", "/admin/member-info/*"})
@Order(1)
public class XssFilter implements Filter {
    final String[] charset = {"\"","\\","<",">"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(req.getMethod().equals("POST")){
            System.out.println("------");
            Map<String, String[]> map = req.getParameterMap();
            for(Map.Entry<String, String[]> entry : map.entrySet()){
                // “”,/,\,<,>”
                for(String v : entry.getValue()){
                    for(String ch : charset){
                        if(v.contains(ch)){
                            System.out.println("ch: "+v+", "+ch);
                            resp.setStatus(400);
                            response.getWriter().write("error");
                            return;
                        }
                    }
                }
            }
        }

        chain.doFilter(request, response);
    }

}
