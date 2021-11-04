package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class RandomLottoMachine implements LottoGenerator {

	private final LottoRule rule;
	private List<LottoNumber> numberList;

	private RandomLottoMachine(LottoRule rule) {
		validate(rule);
		this.rule = rule;
	}

	public static RandomLottoMachine from(LottoRule lottoRule) {
		return new RandomLottoMachine(lottoRule);
	}

	@Override
	public Lotto lotto() {
		return Lotto.from(sortedNumbers(pickNumbers(shuffledNumbers())));
	}

	@Override
	public String toString() {
		return "RandomLottoMachine{" +
			"rule=" + rule +
			", numberList=" + numberList +
			'}';
	}

	private Collection<LottoNumber> sortedNumbers(List<LottoNumber> numbers) {
		List<LottoNumber> newNumbers = new ArrayList<>(numbers);
		Collections.sort(newNumbers);
		return newNumbers;
	}

	private List<LottoNumber> pickNumbers(List<LottoNumber> lottoNumbers) {
		List<LottoNumber> numbers = new ArrayList<>();
		for (int index = 0; index < rule.count(); index++) {
			numbers.add(lottoNumbers.get(index));
		}
		return numbers;
	}

	private List<LottoNumber> shuffledNumbers() {
		List<LottoNumber> lottoNumbers = numbers();
		Collections.shuffle(lottoNumbers);
		return lottoNumbers;
	}

	private List<LottoNumber> numbers() {
		if (numberList == null) {
			numberList = newNumbers();
		}
		return numberList;
	}

	private void validate(LottoRule rule) {
		if (rule == null) {
			throw new IllegalArgumentException("'rule' must not be null");
		}
	}

	private List<LottoNumber> newNumbers() {
		List<LottoNumber> numbers = new ArrayList<>();
		for (int number : rule.numbers()) {
			numbers.add(LottoNumber.from(number));
		}
		return numbers;
	}
}
