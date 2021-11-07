package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	public static final int RANGE_MIN_NUMBER = 1;
	public static final int RANGE_MAX_NUMBER = 45;
	public static final int RANGE_MIN_LIST_INDEX = 0;
	public static final int RANGE_MAX_LIST_INDEX = 6;

	private final List<Integer> lottoRangeNumbers;

	public LottoMachine() {
		this.lottoRangeNumbers = IntStream.range(RANGE_MIN_NUMBER, RANGE_MAX_NUMBER)
			.boxed()
			.collect(Collectors.toList());
	}

	private List<Integer> generateLottoNumber() {
		Collections.shuffle(this.lottoRangeNumbers);
		return lottoRangeNumbers.stream()
			.limit(RANGE_MAX_LIST_INDEX)
			.sorted()
			.collect(Collectors.toList());
	}

	public Lottos generateLottos(int purchaseQuantity) {
		List<Lotto> lottos = IntStream.range(0, purchaseQuantity)
			.mapToObj(lotto -> new Lotto(generateLottoNumber()))
			.collect(Collectors.toList());
		return new Lottos(lottos);
	}
}
