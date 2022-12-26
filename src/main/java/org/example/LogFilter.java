package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String method = ((HttpServletRequest) request).getMethod();
        String header = ((HttpServletRequest) request).getHeader("Accept-Language");
        if (!("GET".equalsIgnoreCase(method) && ("Accept-Language".equalsIgnoreCase(header)))) {
            System.out.println(((HttpServletRequest) request).getRequestURI());
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
