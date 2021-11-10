package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	public static final int RANGE_MIN_NUMBER = 1;
	public static final int RANGE_MAX_NUMBER = 45;
	public static final int RANGE_MIN_LIST_INDEX = 0;
	public static final int RANGE_MAX_LIST_INDEX = 6;

	private final List<LottoNumber> lottoRangeNumbers;

	public LottoMachine() {
		this.lottoRangeNumbers = IntStream.range(RANGE_MIN_NUMBER, RANGE_MAX_NUMBER)
			.boxed()
			.map(LottoNumber::of)
			.collect(Collectors.toList());
	}

	private Set<LottoNumber> generateLottoNumber() {
		Collections.shuffle(this.lottoRangeNumbers);
		return lottoRangeNumbers.stream()
			.limit(RANGE_MAX_LIST_INDEX)
			.collect(Collectors.toSet());
	}

	public Lottos generateLottos(Buyer buyer) {
		return buyer.mergeLottos(IntStream.range(RANGE_MIN_LIST_INDEX, buyer.getRemainingNumber())
			.mapToObj(lotto -> new Lotto(generateLottoNumber()))
			.collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new)));
	}
}
