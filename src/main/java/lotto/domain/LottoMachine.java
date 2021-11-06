package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	public static final int RANGE_MIN_NUMBER = 1;
	public static final int RANGE_MAX_NUMBER = 45;
	public static final int RANGE_MIN_LIST_INDEX = 0;
	public static final int RANGE_MAX_LIST_INDEX = 6;

	private final List<LottoNumber> lottoRangeNumbers;

	public LottoMachine() {
		this.lottoRangeNumbers = new ArrayList<>(
			IntStream.range(RANGE_MIN_NUMBER, RANGE_MAX_NUMBER)
				.mapToObj(LottoNumber::new)
				.collect(Collectors.toList())
		);
	}

	private List<LottoNumber> generateLottoNumber() {
		Collections.shuffle(this.lottoRangeNumbers);
		return this.lottoRangeNumbers.subList(RANGE_MIN_LIST_INDEX, RANGE_MAX_LIST_INDEX);
	}

	public List<Lotto> buyLottos(LottoMoney money){
		int index = money.buyCount();
		List<Lotto> lottos = new ArrayList<>();

		while(index-- > 0){
			lottos.add(new Lotto(generateLottoNumber()));
		}

		return Collections.unmodifiableList(lottos);
	}
}
