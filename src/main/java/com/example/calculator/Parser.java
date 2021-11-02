package com.example.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final Integer CUSTOM_DELIMITER_GROUP = 1;
	private static final Integer CUSTOM_TEXT_GROUP = 2;

	public static ParsedString parse(String string) {
		Matcher matcher = CUSTOM_PATTERN.matcher(string);
		if (matcher.find()) {
			Delimiter delimiter = new Delimiter(matcher.group(CUSTOM_DELIMITER_GROUP));
			Remainder remainder = new Remainder(matcher.group(CUSTOM_TEXT_GROUP));
			return new ParsedString(delimiter, remainder);
		}

		return new ParsedString(new Delimiter(), new Remainder(string));
	}
}
