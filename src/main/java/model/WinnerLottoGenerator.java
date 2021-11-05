package model;

import java.util.HashSet;

public final class WinnerLottoGenerator implements LottoGenerator<WinnerLotto> {

	private final StringsProvider provider;
	private final String bonus;
	private final LottoRule rule;

	private WinnerLotto cachedLotto;

	private WinnerLottoGenerator(StringsProvider provider, String bonus, LottoRule rule) {
		validateNonNull(provider, "'stringsProvider' must not be null");
		validateNonNull(bonus, "'bonus' must not be null");
		validateNonNull(rule, "'rule' must not be null");
		this.provider = provider;
		this.bonus = bonus;
		this.rule = rule;
	}

	public static WinnerLottoGenerator of(StringsProvider numbersProvider, String bonusString, LottoRule rule) {
		return new WinnerLottoGenerator(numbersProvider, bonusString, rule);
	}

	public WinnerLotto lotto() {
		return cachedLotto();
	}

	@Override
	public String toString() {
		return "WinnerLottoGenerator{" +
			"provider=" + provider +
			", rule=" + rule +
			", cachedLotto=" + cachedLotto +
			'}';
	}

	private WinnerLotto cachedLotto() {
		if (cachedLotto == null) {
			cachedLotto = newLotto();
		}
		return cachedLotto;
	}

	private WinnerLotto newLotto() {
		HashSet<LottoNumber> lottoNumbers = new HashSet<>();
		for (String stringNumber : provider.provide()) {
			lottoNumbers.add(lottoNumber(stringNumber));
		}
		validateSize(lottoNumbers);
		return WinnerLotto.from(LottoNumbers.from(lottoNumbers), lottoNumber(bonus));
	}

	private LottoNumber lottoNumber(String stringNumber) {
		return LottoNumber.from(parseValidInt(stringNumber));
	}

	private void validateSize(HashSet<LottoNumber> numbers) {
		if (rule.differentCount(numbers.size())) {
			throw new IllegalArgumentException(
				String.format("Lotto Number must be %d, but provided %d", rule.count(), numbers.size()));
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

	private void validateNonNull(Object target, String message) {
		if (target == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
