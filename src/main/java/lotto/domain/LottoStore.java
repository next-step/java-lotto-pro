package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStore {

	private final LottoMachine lottoMachine;

	public LottoStore() {
		this.lottoMachine = new LottoMachine();
	}

	public Lotto generateLotto(List<Integer> lottoNumbers) {
		return new Lotto(lottoNumbers.stream()
			.map(LottoNumber::of)
			.collect(Collectors.toSet()));
	}

	public Lottos buyLottos(int autoQuantity) {
		return buyLottos(autoQuantity, new Lottos());
	}

	public Lottos buyLottos(int autoQuantity, Lottos manualLottos) {
		return manualLottos.mergeLottos(lottoMachine.generateAutoLottos(autoQuantity));
	}
}
