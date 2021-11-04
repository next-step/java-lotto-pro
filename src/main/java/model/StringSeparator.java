package model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class StringSeparator implements StringsProvider {

	private final String target;
	private final String delimiter;

	private StringSeparator(String target, String delimiter) {
		validateTarget(target);
		validateDelimiter(delimiter);
		this.target = target;
		this.delimiter = delimiter;
	}

	public static StringSeparator of(String target, String delimiter) {
		return new StringSeparator(target, delimiter);
	}

	@Override
	public Collection<String> provide() {
		return Collections.unmodifiableList(Arrays.asList(target.split(this.delimiter)));
	}

	private void validateDelimiter(String delimiter) {
		if (delimiter == null) {
			throw new IllegalArgumentException("'delimiter' must not be null");
		}
	}

	private void validateTarget(String target) {
		if (target == null) {
			throw new IllegalArgumentException("'target' to be split must not be null");
		}
	}
}
