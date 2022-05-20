package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
	private List<LottoNumbers> lottos;

	public Lottos(List<LottoNumbers> lottos) {
		this.lottos = lottos;
	}

	public Lottos(LottoNumbers... lottos) {
		if (this.lottos == null) {
			this.lottos = new ArrayList<>();
		}
		this.lottos.clear();
		for (LottoNumbers lotto : lottos) {
			this.lottos.add(lotto);
		}
	}

	public List<LottoNumbers> getLottos() {
		return lottos;
	}

	public int size() {
		return lottos.size();
	}
}
