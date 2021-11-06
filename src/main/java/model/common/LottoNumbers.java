package model.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import utility.Assert;

public final class LottoNumbers {

	private final Collection<LottoNumber> collection;

	private LottoNumbers(Collection<LottoNumber> collection) {
		Assert.notEmpty(collection, "'collection' must not be empty");
		this.collection = collection;
	}

	public static LottoNumbers from(Collection<LottoNumber> collection) {
		return new LottoNumbers(collection);
	}

	public int containsCount(LottoNumbers numbers) {
		int count = 0;
		for (LottoNumber number : numbers.collection) {
			count += containsCount(number);
		}
		return count;
	}

	public boolean contains(LottoNumber number) {
		return collection.contains(number);
	}

	public boolean notContains(LottoNumber number) {
		return !contains(number);
	}

	@Override
	public String toString() {
		return collection.stream()
			.map(LottoNumber::toString)
			.collect(Collectors.joining(", "));
	}

	public LottoNumbers sort() {
		List<LottoNumber> list = list();
		Collections.sort(list);
		return new LottoNumbers(list);
	}

	public LottoNumbers random(int count) {
		validateCount(count);
		List<LottoNumber> shuffledList = shuffledList();
		List<LottoNumber> numbers = new ArrayList<>();
		for (int index = 0; index < count; index++) {
			numbers.add(shuffledList.get(index));
		}
		return new LottoNumbers(numbers);
	}

	private void validateCount(int count) {
		validateNegative(count, String.format("random Count(%d) must be positive", count));
		validateSize(count, String.format("can not choose %d because the size is %d", count, collection.size()));
	}

	private void validateNegative(int count, String message) {
		if (count < 0) {
			throw new IllegalArgumentException(message);
		}
	}

	private void validateSize(int count, String message) {
		if (collection.size() < count) {
			throw new IllegalArgumentException(message);
		}
	}

	private List<LottoNumber> shuffledList() {
		List<LottoNumber> list = list();
		Collections.shuffle(list);
		return list;
	}

	private List<LottoNumber> list() {
		return new ArrayList<>(collection);
	}

	private int containsCount(LottoNumber number) {
		if (contains(number)) {
			return 1;
		}
		return 0;
	}
}
