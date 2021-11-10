package lotto.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
	private final List<LottoNumbers> inputLottoNumbersList;
	private final List<LottoNumbers> randomLottoNumbersList;

	private Lottos(List<LottoNumbers> inputLottoNumbersList, List<LottoNumbers> randomLottoNumbersList) {
		this.inputLottoNumbersList = Collections.unmodifiableList(inputLottoNumbersList);
		this.randomLottoNumbersList = Collections.unmodifiableList(randomLottoNumbersList);
	}

	public static Lottos of(List<LottoNumbers> inputLottoNumbersList, List<LottoNumbers> randomLottoNumbersList) {
		return new Lottos(inputLottoNumbersList, randomLottoNumbersList);
	}

	public List<LottoNumbers> getLottoNumbersList() {
		return Stream.of(inputLottoNumbersList, randomLottoNumbersList)
			.flatMap(Collection::stream)
			.collect(Collectors.toList());
	}

	public int size() {
		return getLottoNumbersList().size();
	}

	public int inputSize() {
		return inputLottoNumbersList.size();
	}

	public int randomSize() {
		return randomLottoNumbersList.size();
	}

	public Money purchaseMoney() {
		return Money.from(Money.LOTTO_PRICE.multiply(new BigDecimal(size())));
	}
}
