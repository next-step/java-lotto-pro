package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lottos {
	private final List<LottoNumbers> lottoNumbersList;
	private final Money inputMoney;

	private Lottos(List<LottoNumbers> lottoNumbersList, Money inputMoney) {
		this.lottoNumbersList = Collections.unmodifiableList(lottoNumbersList);
		this.inputMoney = inputMoney;
	}

	public static Lottos of(List<LottoNumbers> lottoNumbersList, String inputMoney) {
		return new Lottos(lottoNumbersList, Money.from(inputMoney));
	}

	public static Lottos of(List<LottoNumbers> lottoNumbersList, Money inputMoney) {
		return new Lottos(lottoNumbersList, inputMoney);
	}

	public boolean contains(LottoNumbers lottoNumbers) {
		return this.lottoNumbersList.contains(lottoNumbers);
	}

	public List<LottoNumbers> getLottoNumbersList() {
		return lottoNumbersList;
	}

	public int getInputMoney() {
		return inputMoney.getMoney();
	}

	public int size() {
		return lottoNumbersList.size();
	}
}
