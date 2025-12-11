package com.mphasis.beans;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class SpELDemo {
	@Value("#{10+20}")
	private int add;
	@Value("#{12*21}")
	private int mul;
	@Value("#{10/3}")
	private float div;
	@Value("#{'praveen'.length()>7?'haiiii':'hellooo'}")
	private String result;
	@Value("#{5>3}")
	private boolean flag;
	@Value("#{'hello'.concat(' world')}")
	private String concatstr;
	@Value("#{T(java.time.LocalDate).now}")
	private LocalDate todayDate;
	@Value("#{T(java.lang.Math).pow(5,2)}")
	private double power;
	@Value("#{'praveen,barath,saro'.split(',')}")
	private List<String> names;

	public void printAll()
	{
		System.out.println("Addition: "+add);
		System.out.println("Multiplication: "+mul);
		System.out.println("Division : "+div);
		System.out.println("String: "+result);
		System.out.println("condition: "+flag);
		System.out.println("Concat: "+concatstr);
		System.out.println("todayDate: "+todayDate);
		System.out.println("Power of numbers: "+power);
		names.forEach(System.out::println);
	}
	
	

	
	
	

}
