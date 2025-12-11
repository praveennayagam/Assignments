package com.mphasis.beans;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
@Component
public class SpELProgrameticalDemo {
	
	public void runExpression()
	{
		ExpressionParser parser=new SpelExpressionParser();
		Expression exp=parser.parseExpression("10+20");
		System.out.println(exp.getValue());
		
		exp=parser.parseExpression("'Hello'.length()");
		System.out.println(exp.getValue());
		
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.setVariable("num", 20);

		 exp = parser.parseExpression("#num % 2 == 0 ? 'even' : 'odd'");
		System.out.println(exp.getValue(context));  

	}

}
