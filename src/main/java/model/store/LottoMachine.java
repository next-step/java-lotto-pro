package model.store;

import java.util.ArrayList;
import java.util.Collection;

import model.LottoPaper;
import model.LottoPapers;
import model.common.StringNumberConverter;
import model.common.string.StringsProvider;
import model.generator.LottoGenerator;
import model.generator.ManualLottoGenerator;
import utility.Assert;

public class LottoMachine {

	private final StringNumberConverter converter;
	private final LottoGenerator<LottoPaper> randomGenerator;

	private LottoMachine(StringNumberConverter converter, LottoGenerator<LottoPaper> randomGenerator) {
		Assert.notNull(converter, "'converter' must not be null");
		Assert.notNull(randomGenerator, "'randomGenerator' must not be null");
		this.converter = converter;
		this.randomGenerator = randomGenerator;
	}

	public static LottoMachine of(StringNumberConverter converter, LottoGenerator<LottoPaper> randomGenerator) {
		return new LottoMachine(converter, randomGenerator);
	}

	public LottoPapers manualLotto(Collection<StringsProvider> numbers) {
		ArrayList<LottoPaper> lottoPapers = new ArrayList<>();
		for (StringsProvider provider : numbers) {
			lottoPapers.add(ManualLottoGenerator.of(converter, provider).lotto());
		}
		return LottoPapers.from(lottoPapers);
	}

	public LottoPapers randomLotto(int count) {
		ArrayList<LottoPaper> lottoPapers = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottoPapers.add(randomGenerator.lotto());
		}
		return LottoPapers.from(lottoPapers);
	}
}
