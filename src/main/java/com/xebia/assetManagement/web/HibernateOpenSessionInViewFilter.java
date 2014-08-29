package com.xebia.assetManagement.web;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by anirudh on 27/08/14.
 */
@Service
public class HibernateOpenSessionInViewFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(HibernateOpenSessionInViewFilter.class.getName());

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Starting a database transaction");
        sessionFactory.getCurrentSession().beginTransaction();

        // Call the next filter (continue request processing)
        chain.doFilter(request, response);

        // Commit and cleanup
        LOGGER.info("Committing the database transaction");
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void destroy() {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
