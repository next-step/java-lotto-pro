package lotto.model;

import java.util.List;

public class Lottos {
	private List<LottoNumbers> lottos;

	public Lottos(List<LottoNumbers> lottos) {
		this.lottos = lottos;
	}

	public List<LottoNumbers> getLottos() {
		return lottos;
	}

	public int size() {
		return lottos.size();
	}
}
