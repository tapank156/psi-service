package com.scholastic.scent.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppDispatcherServlet extends DispatcherServlet{
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(AppDispatcherServlet.class);

   @Override
   public void init(ServletConfig config) throws ServletException {
	   logger.info("Dispatcher servlet init method");
	   super.init(config);
	   ServletContext context = config.getServletContext();
	   context.setAttribute("context", context.getContextPath());
   }
  
   @Override
   protected WebApplicationContext initWebApplicationContext()  throws BeansException {
       logger.info("Dispatcher servlet WebApplicationContext method");
       WebApplicationContext wac = super.initWebApplicationContext();
       if(wac != null){
	       logger.info("WAC Display Name " + wac.getDisplayName());
	       String[] beanNames = wac.getBeanDefinitionNames();
	       for(String bean:beanNames){
	    	   logger.info(" bean names " + bean) ;
	       }
       }else{
           logger.info("Web Application context is null ") ;
       }
       return wac;
   }	
}