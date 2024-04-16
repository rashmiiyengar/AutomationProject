package com.rs.enums;


/**
 * Enums to restrict the users to choose an appropriate waiting stratergy before operating an element.
 
 * 
 * @author rashmisoundar
 * @see com.rs.factories.ExplicitWaitFactory
 * @see com.rs.pages.BasePage
	Apr 15, 2024
 */
public enum WaitStratergy {

	CLICKABLE,
	PRESENCE,
	VISIBLE,
	NONE
}
