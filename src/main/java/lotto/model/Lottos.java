package lotto.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Lottos {
	private final List<LottoNumbers> lottoNumbersList;

	private Lottos(List<LottoNumbers> lottoNumbersList) {
		this.lottoNumbersList = Collections.unmodifiableList(lottoNumbersList);
	}

	public static Lottos of(List<LottoNumbers> lottoNumbersList) {
		return new Lottos(lottoNumbersList);
	}

	public List<LottoNumbers> getLottoNumbersList() {
		return this.lottoNumbersList;
	}

	public int size() {
		return getLottoNumbersList().size();
	}

	public Money purchaseMoney() {
		return Money.LOTTO_PRICE.calculatePurchaseMoney(new BigDecimal(size()));
	}
}
