package utility;

import java.util.ArrayList;
import java.util.Collection;

final class StringNumberSeparator {

	private final StringDelimiters delimiters;

	public StringNumberSeparator(StringDelimiters delimiters) {
		validate(delimiters);
		this.delimiters = delimiters;
	}

	public static StringNumberSeparator from(StringDelimiters delimiters) {
		return new StringNumberSeparator(delimiters);
	}

	public StringNumbers separate(String target) {
		if (isEmpty(target)) {
			return StringNumbers.empty();
		}
		return StringNumbers.from(delimitedCollection(target));
	}

	@Override
	public String toString() {
		return "StringNumberSeparator{" +
			"delimiters=" + delimiters +
			'}';
	}

	private void validate(StringDelimiters delimiters) {
		if (delimiters == null) {
			throw new IllegalArgumentException("delimiters must not be null");
		}
	}

	private Collection<StringNumber> delimitedCollection(String target) {
		ArrayList<StringNumber> numbers = new ArrayList<>();
		for (String splitString : target.split(delimiters.regex())) {
			numbers.add(StringNumber.of(splitString));
		}
		return numbers;
	}

	private boolean isEmpty(String target) {
		return target == null || target.trim().isEmpty();
	}
}
