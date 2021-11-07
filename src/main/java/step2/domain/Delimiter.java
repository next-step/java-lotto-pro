package step2.domain;

import java.util.regex.Pattern;

public class Delimiter {

	private final String delimiter;
	private String regex;

	public Delimiter() {
		this.delimiter = ",|:";
		this.regex = this.delimiter;
	}

	public Delimiter(String delimiter) {
		this.delimiter = delimiter;
		this.regex = delimiter;

		// 특수문자일 경우
		if (Pattern.compile("[!@#$%^&*()_+-=,.?\":{}|<>]").matcher(delimiter).find()) {
			this.regex = "\\" + delimiter;
		}
	}

	public String getDelimiter() {
		return this.delimiter;
	}
	public String getRegex() {
		return this.regex;
	}
}
