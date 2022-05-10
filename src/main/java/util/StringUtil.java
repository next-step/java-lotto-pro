package util;

public class StringUtil {
	public static final String COMMA = ",";
	public static final char LEFT_PARENTHESIS = '(';
	public static final char RIGHT_PARENTHESIS = ')';
	
	public static String[] splitComma(String value) {
		return value.split(COMMA);
	}

	public static String removeParentheses(String value) {
		if (isEitherEndParenthesis(value)) {
			return value.substring(1, value.length()-1);
		}
		return value;
	}
	
	private static boolean isEitherEndParenthesis(String value) {
		return value.charAt(0) == LEFT_PARENTHESIS && value.charAt(value.length()-1) == RIGHT_PARENTHESIS;
	}
	
	public static char findCharacter(String value, int index) {
		if (!compareLength(value, index)) {
			throw new StringIndexOutOfBoundsException("Index: " + index + ", Value Length: " + value.length() + " 문자열의 길이는 index의 길이보다 작아야 합니다.");
		}
		
		return value.charAt(index);
	}
	
	private static boolean compareLength(String value, int index) {
		return value.length() > index;
	}
}
