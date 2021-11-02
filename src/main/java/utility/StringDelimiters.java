package utility;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

final class StringDelimiters {

	private static final String REGEX_DELIMITER = "|";

	private final Collection<String> delimiters;

	StringDelimiters(Collection<String> delimiters) {
		validate(delimiters);
		this.delimiters = delimiters;
	}

	public static StringDelimiters of(String delimiter, String... delimiters) {
		HashSet<String> delimiterSet = new HashSet<>(Arrays.asList(delimiters));
		delimiterSet.add(delimiter);
		return new StringDelimiters(delimiterSet);
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

	private void validate(Collection<String> delimiters) {
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
