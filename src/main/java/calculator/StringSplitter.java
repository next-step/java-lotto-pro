package calculator;

import calculator.utils.StringUtils;

public class StringSplitter {
	private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

	public static String[] split(String text) {
		if (StringUtils.isEmpty(text)) {
			return new String[]{};
		}

		return text.split(DEFAULT_DELIMITER_REGEX);
	}
}
