package model;

import java.util.HashSet;

public final class WinnerLottoGenerator implements LottoGenerator {

	private final StringsProvider provider;
	private final LottoRule rule;

	private Lotto cachedLotto;

	private WinnerLottoGenerator(StringsProvider provider, LottoRule rule) {
		validate(provider);
		validate(rule);
		this.provider = provider;
		this.rule = rule;
	}

	public static WinnerLottoGenerator of(StringsProvider provider, LottoRule rule) {
		return new WinnerLottoGenerator(provider, rule);
	}

	public Lotto lotto() {
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

	private Lotto cachedLotto() {
		if (cachedLotto == null) {
			cachedLotto = newLotto();
		}
		return cachedLotto;
	}

	private Lotto newLotto() {
		HashSet<LottoNumber> lottoNumbers = new HashSet<>();
		for (String stringNumber : provider.provide()) {
			lottoNumbers.add(LottoNumber.from(parseValidInt(stringNumber)));
		}
		validateSize(lottoNumbers);
		return Lotto.from(lottoNumbers);
	}

	private void validateSize(HashSet<LottoNumber> numbers) {
		if (rule.differentCount(numbers.size())) {
			throw new IllegalArgumentException(
				String.format("Lotto Number must be %d, but provided %d", rule.count(), numbers.size()));
		}
	}

	private int parseValidInt(String stringNumber) {
		int number = parseInt(stringNumber);
		if (rule.invalidNumber(number)) {
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

	private void validate(StringsProvider provider) {
		if (provider == null) {
			throw new IllegalArgumentException("'stringsProvider' must not be null");
		}
	}

	private void validate(LottoRule rule) {
		if (rule == null) {
			throw new IllegalArgumentException("'rule' must not be null");
		}
	}
}
