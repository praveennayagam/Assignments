package com.mphasis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mphasis.beans.Order;
import com.mphasis.config.ConfigClass;


public class App {
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigClass.class);
		Order o=(Order) context.getBean("order");
		System.out.println(o);
		o.getItems();
		context.close();
    }
}
