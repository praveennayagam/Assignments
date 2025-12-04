package com.mphasis;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Main {

	public static void main(String[] args) throws LifecycleException {
	
		Tomcat tomcat=new Tomcat();
		tomcat.setPort(8080);
		tomcat.addWebapp("", "src/main/webapp");
		tomcat.start();
		tomcat.getServer().await();

	}

}