package util;

public class StringUtil {
	public static String[] splitComma(String value) {
		return value.split(",");
	}

	public static String removeParentheses(String value) {
		if(value.charAt(0) == '(' && value.charAt(value.length()-1) == ')' ) {
			return value.substring(1,value.length()-1);
		}
		return value;
	}
	
	public static char findCharacter(String value, int index) {
		if(value.length() <= index) {
			throw new StringIndexOutOfBoundsException("Index: " + index + ", Value Length: " + value.length() + " 문자열의 길이는 index의 길이보다 작아야 합니다.");
		}
		
		return value.charAt(index);
	}
}
