package com.mphasis;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppListener() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	    	ServletContextListener.super.contextInitialized(sce);
    	    	System.out.println("App initialized");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	
    	ServletContextListener.super.contextDestroyed(sce);
    	System.out.println("App destroyed");
    	
    }
    
    
	
}
