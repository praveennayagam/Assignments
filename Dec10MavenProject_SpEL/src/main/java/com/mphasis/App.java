package com.mphasis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mphasis.beans.Order;
import com.mphasis.beans.SpELDemo;
import com.mphasis.beans.SpELProgrameticalDemo;
import com.mphasis.config.ConfigClass;


public class App {
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigClass.class);
//		Order o=(Order) context.getBean("order");
//		System.out.println(o);
//		o.getItems();
		
    	
//    	SpELDemo s=(SpELDemo) context.getBean("spELDemo");
//    	s.printAll();
    	
    	SpELProgrameticalDemo s1=(SpELProgrameticalDemo) context.getBean("spELProgrameticalDemo");
    	s1.runExpression();
    	
    	context.close();
    }
}
