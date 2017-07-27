package com.qsrversion.annotations;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ METHOD, TYPE, CONSTRUCTOR })
public @interface TestInfo {

	/**
	 * The ID of the test case should be placed in. This attribute is ignore if
	 * TestInfo is not at the class level.
	 */
	public String testCaseID() default "";

	/**
	 * 
	 * The description of the test case should be placed in. This attribute is
	 * ignore if @TestInfo is not at the class level.
	 */
	public String testCaseDescription() default "";

}
