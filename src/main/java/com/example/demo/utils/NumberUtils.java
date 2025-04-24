package com.example.demo.utils;

public final class NumberUtils {
	
	public static Double convertToDouble(String strNumber){
		if(strNumber == null || strNumber.isEmpty()){
			throw new IllegalArgumentException();
		}
		return Double.parseDouble(strNumber.replace(",", "."));
	}
	
	public static boolean isValidNumeric(String strNumber) {
		if(strNumber == null || strNumber.isEmpty()) return false;
		return strNumber.matches("[-+]?[0-9]*[,.]?[0-9]+([eE][-+]?[0-9]+)?");
	}
}
