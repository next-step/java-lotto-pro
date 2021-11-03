package utility;

import java.util.Collection;
import java.util.Collections;

final class StringNumbers {

	private static final int DEFAULT_SUM_VALUE = 0;
	private final Collection<StringNumber> collection;

	private StringNumbers(Collection<StringNumber> collection) {
		validate(collection);
		this.collection = collection;
	}

	public static StringNumbers empty() {
		return new StringNumbers(Collections.emptyList());
	}

	public static StringNumbers from(Collection<StringNumber> collection) {
		return new StringNumbers(collection);
	}

	public int sum() {
		int sum = DEFAULT_SUM_VALUE;
		for (StringNumber number : collection) {
			sum += number.parseInt();
		}
		return sum;
	}

	@Override
	public String toString() {
		return "StringNumbers{" +
			"collection=" + collection +
			'}';
	}

	private void validate(Collection<StringNumber> collection) {
		if (collection == null) {
			throw new IllegalArgumentException("collection must not be null");
		}
	}
}
