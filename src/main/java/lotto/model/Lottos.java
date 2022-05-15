package lotto.model;

import java.util.List;

public final class Lottos {
	private List<LottoNumbers> lottos;

	public Lottos(List<LottoNumbers> lottos) {
		this.lottos = lottos;
	}

	public List<LottoNumbers> getLottos() {
		return lottos;
	}
}
