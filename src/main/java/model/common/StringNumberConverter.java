package model.common;

import java.util.HashSet;

import model.common.string.StringsProvider;
import utility.Assert;

public final class StringNumberConverter {

	private final LottoRule rule;

	private StringNumberConverter(LottoRule rule) {
		Assert.notNull(rule, "'rule' must not be null");
		this.rule = rule;
	}

	public static StringNumberConverter from(LottoRule rule) {
		return new StringNumberConverter(rule);
	}

	public LottoNumbers lottoNumbers(StringsProvider provider) {
		HashSet<LottoNumber> lottoNumbers = new HashSet<>();
		for (String stringNumber : provider.provide()) {
			lottoNumbers.add(lottoNumber(stringNumber));
		}
		validateSize(lottoNumbers);
		return LottoNumbers.from(lottoNumbers);
	}

	public LottoNumber lottoNumber(String stringNumber) {
		return LottoNumber.from(parseValidInt(stringNumber));
	}

	private void validateSize(HashSet<LottoNumber> numbers) {
		if (rule.differentCount(numbers.size())) {
			throw new IllegalArgumentException(
				String.format("lotto Number must be %d, but provided %d", rule.count(), numbers.size()));
		}
	}

	private int parseValidInt(String stringNumber) {
		int number = parseInt(stringNumber);
		if (rule.outOfRange(number)) {
			throw new IllegalArgumentException(
				String.format("number(%s) must be between min(%d) and max(%d)", stringNumber, rule.minNumber(),
					rule.maxNumber()));
		}
		return number;
	}

	private int parseInt(String stringNumber) {
		try {
			return Integer.parseInt(stringNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(String.format("'%s' can not be changed to number", stringNumber), e);
		}
	}

}
