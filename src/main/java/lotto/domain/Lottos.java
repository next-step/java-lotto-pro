package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottoList) {
		this.lottos = Collections.unmodifiableList(lottoList);
	}

	public int quantity() {
		return lottos.size();
	}

	public List<Rank> match(Lotto standardLotto, LottoNumber bonusNumber) {
		return lottos.stream()
			.map(lotto -> standardLotto.match(lotto, bonusNumber))
			.collect(Collectors.toList());
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

}
