package com.operationsmanagement.workshop.backend.system.util;

public class StringUtils {

	public static String getClassTypeName(Class clazz) {
		return clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1);
	}

}
