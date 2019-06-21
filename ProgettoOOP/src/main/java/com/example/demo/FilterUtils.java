package com.example.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

public class FilterUtils<T> {
	public static boolean checkConditional(Object value, String operator, Object th) {
		if (th instanceof Number && value instanceof Number) {	
			Double thC = ((Number)th).doubleValue();
			Double valuec = ((Number)value).doubleValue();
			if (operator.equals("$eq"))
				return value.equals(th);
			else if (operator.equals("$gt"))
				return valuec > thC;
			else if (operator.equals("$lt"))
				return valuec < thC;
			}else if(th instanceof String && value instanceof String)
			return value.equals(th);
		return false;		
}
}