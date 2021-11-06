package step3;

import java.util.regex.Pattern;

public class PattenUtils {

	public static boolean findString(String patten, String str) {
		return Pattern.matches(patten, str);
	}
}
