package model.common.string;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import utility.Assert;

public final class StringSeparator implements StringsProvider {

	private final String target;
	private final StringDelimiters delimiters;

	private StringSeparator(String target, StringDelimiters delimiters) {
		Assert.notNull(target, "'target' to be split must not be null");
		Assert.notNull(delimiters, "'delimiters' must not be null");
		this.target = target;
		this.delimiters = delimiters;
	}

	public static StringSeparator of(String target, StringDelimiters delimiters) {
		return new StringSeparator(target, delimiters);
	}

	@Override
	public Collection<String> provide() {
		return Collections.unmodifiableList(Arrays.asList(target.split(delimiters.regex())));
	}

	@Override
	public String toString() {
		return "StringSeparator{" +
			"target='" + target + '\'' +
			", delimiter=" + delimiters +
			'}';
	}
}
