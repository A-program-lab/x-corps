package com.theatreService.aop;


import java.util.Date; // Add this import statement

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	    @Before(value = "execution(* com.theatreService.controller.TheatreController.*(..))")
	    public void beforeAdvice(JoinPoint joinPoint) {
	        System.out.println("Request to " + joinPoint.getSignature() + " started at " + new Date());
	    }
	}

