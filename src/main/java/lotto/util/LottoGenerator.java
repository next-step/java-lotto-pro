package lotto.util;

import static lotto.constants.LottoConstants.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoGenerator {
	private static final List<Integer> LOTTO_NUMBERS;
	private static final int LOTTO_PICKED = 6;

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

	public static Lottos purchaseLottos(int numberOfAutoCreation) {
		return new Lottos(IntStream.range(0, numberOfAutoCreation)
			.mapToObj(i -> LottoGenerator.generateAuto())
			.collect(Collectors.toList()));
	}

	public static Lottos purchaseLottos(int numberOfAutoCreation, Lotto... lottos) {
		return new Lottos(Stream.concat(IntStream.range(0, numberOfAutoCreation)
			.mapToObj(i -> LottoGenerator.generateAuto()), Arrays.stream(lottos)).collect(Collectors.toList()));
	}

	private LottoGenerator() {
	}
}
