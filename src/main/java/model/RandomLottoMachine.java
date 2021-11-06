package model;

import java.util.ArrayList;
import java.util.List;

import utility.Assert;

public final class RandomLottoMachine implements LottoGenerator<LottoPaper> {

	private final LottoRule rule;
	private LottoNumbers lottoNumbers;

	private RandomLottoMachine(LottoRule rule) {
		Assert.notNull(rule, "'rule' must not be null");
		this.rule = rule;
	}

	public static RandomLottoMachine from(LottoRule lottoRule) {
		return new RandomLottoMachine(lottoRule);
	}

	@Override
	public LottoPaper lotto() {
		return LottoPaper.from(numbers()
			.random(rule.count())
			.sort());
	}

	@Override
	public String toString() {
		return "RandomLottoMachine{" +
			"rule=" + rule +
			", lottoNumbers=" + lottoNumbers +
			'}';
	}

	private LottoNumbers numbers() {
		if (lottoNumbers == null) {
			lottoNumbers = newNumbers();
		}
		return lottoNumbers;
	}

	private LottoNumbers newNumbers() {
		List<LottoNumber> numbers = new ArrayList<>();
		for (int number : rule.numbers()) {
			numbers.add(LottoNumber.from(number));
		}
		return LottoNumbers.from(numbers);
	}
}
