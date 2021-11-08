package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
	private static final List<Integer> lottoNumbers;
	private static final int lottoPicked = 6;

	static {
		lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());
	}

	public static Lotto generate() {
		Collections.shuffle(lottoNumbers);
		return new Lotto(lottoNumbers.stream()
			.limit(lottoPicked)
			.sorted()
			.collect(Collectors.toList()));
	}
}
