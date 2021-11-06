package model.generator;

import model.LottoPaper;
import model.common.StringNumberConverter;
import model.common.string.StringsProvider;
import utility.Assert;

public final class ManualLottoGenerator implements LottoGenerator<LottoPaper> {

	private final StringNumberConverter converter;
	private final StringsProvider provider;

	private ManualLottoGenerator(StringNumberConverter converter, StringsProvider provider) {
		Assert.notNull(converter, "'converter' must not be null");
		Assert.notNull(provider, "'stringsProvider' must not be null");
		this.converter = converter;
		this.provider = provider;
	}

	public static ManualLottoGenerator of(StringNumberConverter converter, StringsProvider provider) {
		return new ManualLottoGenerator(converter, provider);
	}

	@Override
	public LottoPaper lotto() {
		return LottoPaper.manual(converter.lottoNumbers(provider));
	}

	@Override
	public String toString() {
		return "ManualLottoGenerator{" +
			"converter=" + converter +
			", provider=" + provider +
			'}';
	}
}
