package model.common.string;

import java.util.Arrays;
import java.util.Collection;

import utility.Assert;

public final class StringDelimiters {

	private static final String REGEX_DELIMITER = "|";

	private final Collection<String> delimiters;

	StringDelimiters(Collection<String> delimiters) {
		Assert.notEmpty(delimiters, "'delimiters' must not be null");
		validateContainsNull(delimiters);
		this.delimiters = delimiters;
	}

	public static StringDelimiters of(String... delimiters) {
		return new StringDelimiters(Arrays.asList(delimiters));
	}

	public String regex() {
		return String.join(REGEX_DELIMITER, delimiters);
	}

	@Override
	public String toString() {
		return "StringDelimiters{" +
			"delimiter=" + delimiters +
			'}';
	}

	private void validateContainsNull(Collection<String> delimiters) {
		for (String delimiter : delimiters) {
			checkNull(delimiter);
		}
	}

	private void checkNull(String delimiter) {
		if (delimiter == null) {
			throw new IllegalArgumentException("delimiter must not be null");
		}
	}
}
