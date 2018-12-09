package com.mvc.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class U {
	
	private U() {
	}

	public static void p(Object param) {
		if (param instanceof Integer) {
			int value = ((Integer) param).intValue();
			System.out.println(value);
		} else if (param instanceof String) {
			String s = (String) param;
			System.out.println(s);
		} else if (param instanceof Double) {
			double d = ((Double) param).doubleValue();
			System.out.println(d);
		} else if (param instanceof Float) {
			float f = ((Float) param).floatValue();
			System.out.println(f);
		} else if (param instanceof Long) {
			long l = ((Long) param).longValue();
			System.out.println(l);
		} else if (param instanceof Boolean) {
			boolean b = ((Boolean) param).booleanValue();
			System.out.println(b);
		} else if (param instanceof Date) {
			Date d = (Date) param;
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(sp.format(d));
		}
	}
}
