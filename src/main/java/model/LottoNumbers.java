package model;

import java.util.Collection;
import java.util.stream.Collectors;

public final class LottoNumbers {

	private final Collection<LottoNumber> collection;

	private LottoNumbers(Collection<LottoNumber> collection) {
		validate(collection);
		this.collection = collection;
	}

	static LottoNumbers from(Collection<LottoNumber> collection) {
		return new LottoNumbers(collection);
	}

	int containsCount(LottoNumbers numbers) {
		int count = 0;
		for (LottoNumber number : numbers.collection) {
			count += containsCount(number);
		}
		return count;
	}

	boolean contains(LottoNumber number) {
		return collection.contains(number);
	}

	@Override
	public String toString() {
		return collection.stream()
			.map(LottoNumber::toString)
			.collect(Collectors.joining(", "));
	}

	private int containsCount(LottoNumber number) {
		if (contains(number)) {
			return 1;
		}
		return 0;
	}

	private void validate(Collection<LottoNumber> numberCollection) {
		if (isEmpty(numberCollection)) {
			throw new IllegalArgumentException("'collection' must not be empty");
		}
	}

	private boolean isEmpty(Collection<LottoNumber> numberCollection) {
		return numberCollection == null || numberCollection.isEmpty();
	}

}
