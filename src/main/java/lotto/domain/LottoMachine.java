package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
	public static final int RANGE_MIN_LIST_INDEX = 0;
	public static final int RANGE_MAX_LIST_INDEX = 6;

	private final List<LottoNumber> lottoRangeNumbers;

	public LottoMachine() {
		this.lottoRangeNumbers = LottoNumber.getLottoNumbers();
	}

	private Lotto shuffleLottoNumbers() {
		Collections.shuffle(this.lottoRangeNumbers);
		return new Lotto(lottoRangeNumbers.stream()
			.limit(RANGE_MAX_LIST_INDEX)
			.collect(Collectors.toSet()));
	}

	public Lottos generateAutoLottos(int autoNumber) {
		return IntStream.range(RANGE_MIN_LIST_INDEX, autoNumber)
			.mapToObj(value -> shuffleLottoNumbers())
			.collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
	}
}
