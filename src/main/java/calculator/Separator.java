package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

	public static final String REGEX_DEFAULT_DELIMITER = ",|:";
	public static final String REGEX_CUSTOM_DELIMITER = "//(.)\\n(.*)";

	private static Pattern compile = Pattern.compile(REGEX_CUSTOM_DELIMITER);

	public static String[] split(String text) {
		Matcher matcher = compile.matcher(text);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}
		return text.split(REGEX_DEFAULT_DELIMITER);
	}

}
