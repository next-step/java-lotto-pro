package model.common.string;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import utility.Assert;

public final class StringSeparator implements StringsProvider {

	private final String target;
	private final String delimiter;

	private StringSeparator(String target, String delimiter) {
		Assert.notNull(target, "'target' to be split must not be null");
		Assert.notNull(delimiter, "'delimiter' must not be null");
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

	@Override
	public String toString() {
		return "StringSeparator{" +
			"target='" + target + '\'' +
			", delimiter='" + delimiter + '\'' +
			'}';
	}
}
