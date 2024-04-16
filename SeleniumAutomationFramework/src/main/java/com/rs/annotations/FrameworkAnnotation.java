package com.rs.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.rs.enums.CategoryType;


/**
 * Framework Annotation is user built annotation which is annotated on top of 
 * test methods to log the author details and category details to the extent report
 * 
 * Runtime retention value indicate that this annotation will be available at runtime for reflection operations.
 * 
 * @author rashmisoundar
 * @see com.rs.testcases
 * @see com.rs.enums.CategoryType
	Apr 15, 2024
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {

	
	public String[] author();	
	public CategoryType[] category();
}
