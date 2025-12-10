package com.mphasis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mphasis.bean.Student;
import com.mphasis.config.SpringConfiguration;

public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
		Student s=(Student) context.getBean(Student.class);
		System.out.println(s);
		context.close();
	}

}
