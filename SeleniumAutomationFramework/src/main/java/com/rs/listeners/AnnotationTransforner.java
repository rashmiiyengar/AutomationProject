package com.rs.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.rs.utils.DataProviderUtils;


/**
 * Implements {@link org.testng.IAnnotationTransformer} to leverage certain functionality like updating the annotations
 * of the test methods at runtime.
 * <pre>Please make sure to add the listener details in testng.xml</pre>
 * 
	Apr 15, 2024
	@author rashmisoundar
	@see com.rs.utils.DataProviderUtils
 */
public class AnnotationTransforner implements IAnnotationTransformer {
	
	/**
	 * Helps in setting the dataprovider, dataprovider class and retry analyser annotation to all the test methods 
	 * at runtime.
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setDataProvider("LoginTestdataProvider");
		annotation.setDataProviderClass(DataProviderUtils.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}
}
