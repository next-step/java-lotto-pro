package lotto.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lotto.constants.LottoConstants;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoGenerator {
	private static final List<Integer> LOTTO_NUMBERS;
	private static final int LOTTO_PICKED = 6;
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 45;

	static {
		LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
			.boxed()
			.collect(Collectors.toList());
	}

	public static Lotto generateAuto() {
		Collections.shuffle(LOTTO_NUMBERS);
		return new Lotto(LOTTO_NUMBERS.stream()
			.limit(LOTTO_PICKED)
			.sorted()
			.collect(Collectors.toList()));
	}

	public static Lottos purchaseLottos(int money) {
		int count = money / LottoConstants.PRICE;
		return new Lottos(IntStream.range(0, count)
			.mapToObj(i -> LottoGenerator.generateAuto())
			.collect(Collectors.toList()));
	}

	public static Lottos purchaseLottos(int money, Lotto... lottos) {
		int count = money / LottoConstants.PRICE - lottos.length;
		return new Lottos(Stream.concat(IntStream.range(0, count)
			.mapToObj(i -> LottoGenerator.generateAuto()), Arrays.stream(lottos)).collect(Collectors.toList()));
	}

	private LottoGenerator() {
	}
}
