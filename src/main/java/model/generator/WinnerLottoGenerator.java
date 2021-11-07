package model.generator;

import model.WinnerLotto;
import model.common.StringNumberConverter;
import model.common.string.StringsProvider;
import utility.Assert;

public final class WinnerLottoGenerator implements LottoGenerator<WinnerLotto> {

	private final StringNumberConverter converter;
	private final StringsProvider provider;
	private final String bonusString;

	public WinnerLottoGenerator(StringNumberConverter converter, StringsProvider provider, String bonusString) {
		Assert.notNull(converter, "'converter' must not be null");
		Assert.notNull(provider, "'stringsProvider' must not be null");
		Assert.notEmpty(bonusString, "'bonusString' must not be empty");
		this.converter = converter;
		this.provider = provider;
		this.bonusString = bonusString;
	}

	public static WinnerLottoGenerator of(
		StringNumberConverter converter, StringsProvider provider, String bonusString) {
		return new WinnerLottoGenerator(converter, provider, bonusString);
	}

	public WinnerLotto lotto() {
		return WinnerLotto.from(converter.lottoNumbers(provider), converter.lottoNumber(bonusString));
	}

	@Override
	public String toString() {
		return "WinnerLottoGenerator{" +
			"converter=" + converter +
			", provider=" + provider +
			", bonusString='" + bonusString + '\'' +
			'}';
	}

}
