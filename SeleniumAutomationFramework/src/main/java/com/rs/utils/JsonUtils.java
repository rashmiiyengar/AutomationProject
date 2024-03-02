package com.rs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rs.constants.FrameworkConstants;
import com.rs.enums.ConfigProperties;

//public class JsonUtils {

	//private static Map<String, String> CONFIGMAP;

	//private JsonUtils() {

	//}

	//static {
	//	try {
	//		CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonConfigfilepath()),
	//				new TypeReference<HashMap<String, String>>() {
	//				});

	//	} catch (IOException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}

	//}

	// Hash map
	//public static String get(ConfigProperties key) throws Exception {

	//	if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
	//		throw new Exception("property name" + key + "is not found pls check properties.config");
	//	}
	//	return CONFIGMAP.get(key.name().toLowerCase());
//	}

//}
