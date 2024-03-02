package com.rs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.rs.constants.FrameworkConstants;
import com.rs.enums.ConfigProperties;

public final class PropertyUtils {

	private PropertyUtils() {

	}

	private static Properties property = new Properties();

	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath());
			property.load(file);

			// for(Object key: property.keySet()) {
			// CONFIGMAP.put(String.valueOf(key),String.valueOf(property.get(key)));
			// }

			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}

			// another way
			// property.entrySet().forEach(entry ->
			// CONFIGMAP.put(String.valueOf(entry.getKey()),
			// String.valueOf(entry.getValue())));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Hash map
	public static String get(ConfigProperties key) throws Exception {

		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("property name" + key + "is not found pls check properties.config");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

	// Hashtable little slow , but thread safe
	public static String getValue(String key) throws Exception {

		if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new Exception("property name" + key + "is not found pls check properties.config");
		}
		return property.getProperty(key);
	}
}
