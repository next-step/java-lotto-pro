package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	private static final String CUSTOM_REGEX = "//(.)\n(.*)";
	private static final String BASIC_REGEX = ",|:";
	
	public static int sum(String value) {
		if (isEmpty(value)) {
			return 0;
		}
		
		List<Number> list = new ArrayList<>();
		for (String number: split(value)) {
			list.add(new Number(number));
		}	
		
		return list.stream().mapToInt(i->i.getNumber()).sum();
	}
	
	private static String[] split(String value){
		Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(value);
		if (matcher.find()) {
		    String customDelimiter = matcher.group(1);
		    return matcher.group(2).split(customDelimiter);
		}
		
		return value.split(BASIC_REGEX);
	}
	
	private static boolean isEmpty(String value) {
		return value == null || value.isEmpty(); 
	}
}
