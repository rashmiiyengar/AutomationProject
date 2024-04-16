package com.rs.enums;


/**
 * Enums to restrict the values used on Property files. Without using enums there can be null pointer exceptions happening.
 * because of typos
 * 
 * <p> Whenever a new value is added to property file, corresponding enum should be created here.
	Apr 15, 2024
	@author rashmisoundar
	@see com.rs.utils.PropertyUtils
 */
public enum ConfigProperties {

	
	URL,
	OVERRIDERREPORTS,
	PASSEDSTEPSCREENSHOT,
	FAILEDSTEPSCREENSHOT,
	SKIPPEDSTEPSCREENSHOT,
	RETRYFAILEDTESTS,
	BROWSER,
	
}
