package util;

public class NumberUtil {
	private NumberUtil() {
	}

	public static boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}