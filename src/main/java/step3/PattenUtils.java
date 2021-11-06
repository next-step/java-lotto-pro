package step3;

import java.util.regex.Pattern;

public class PattenUtils {

	public static boolean match(String patten, String str) {
		return Pattern.matches(patten, str);
	}
}
