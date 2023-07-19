package com.theatreService.aop;


import java.util.Date; // Add this import statement

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.theatreService.controller.LogController;

@Aspect
@Component
public class LoggingAspect {
	Logger logger
	= LoggerFactory.getLogger(LogController.class);

	    @Before(value = "execution(* com.theatreService.controller.TheatreController.*(..))")
	    public void beforeAdvice(JoinPoint joinPoint) {
	        logger.info("Request to " + joinPoint.getSignature() + " started at " + new Date());
	    }
	    @After(value = "execution(* com.theatreService.controller.TheatreController.*(..))")
	    public void afterAdvice(JoinPoint joinPoint) {
	        logger.info("Request to " + joinPoint.getSignature() + " started at " + new Date());
	    }
	    @Before(value = "execution(* com.theatreService.services.TheatreService.*(..))")
	    public void beforeTheateServiceAdvice(JoinPoint joinPoint) {
	        logger.info("Request to " + joinPoint.getSignature() + " started at " + new Date());
	    }
	    @After(value = "execution(* com.theatreService.services.TheatreService.*(..))")
	    public void afterTheateServiceAdvice(JoinPoint joinPoint) {
	        logger.info("Request to " + joinPoint.getSignature() + " started at " + new Date());
	    }
	    @Before(value = "execution(* com.theatreService.services.ScreenService.*(..))")
	    public void beforeScreenServiceAdvice(JoinPoint joinPoint) {
	        logger.info("Request to " + joinPoint.getSignature() + " started at " + new Date());
	    }
	    @After(value = "execution(* com.theatreService.services.ScreenService.*(..))")
	    public void afterScreenServiceAdvice(JoinPoint joinPoint) {
	        logger.info("Request to " + joinPoint.getSignature() + " started at " + new Date());
	    }
	    @Before(value = "execution(* com.theatreService.services.CityService.*(..))")
	    public void beforeScreenCityAdvice(JoinPoint joinPoint) {
	        logger.info("Request to " + joinPoint.getSignature() + " started at " + new Date());
	    }
	    @After(value = "execution(* com.theatreService.services.CityService.*(..))")
	    public void afterScreenCityAdvice(JoinPoint joinPoint) {
	        logger.info("Request to " + joinPoint.getSignature() + " started at " + new Date());
	    }
	}

