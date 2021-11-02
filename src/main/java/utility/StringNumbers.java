package utility;

import java.util.Collection;
import java.util.Collections;

final class StringNumbers {

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
		int sum = 0;
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
