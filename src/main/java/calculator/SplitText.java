package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitText {
	private static final String DEFAULT_SEPARATOR = ",|:";
	private static final String CUSTOM_SEPARATOR = "//(.)\\n(.*)";

	public static String[] split(String text) {
		Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(text);
		if (matcher.find()) {
			return matcher.group(2).split(matcher.group(1));
		}
		return text.split(DEFAULT_SEPARATOR);
	}
}
