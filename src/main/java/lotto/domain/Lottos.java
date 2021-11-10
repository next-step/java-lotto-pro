package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	public Lottos mergeLottos(Lottos targetLottos) {
		return Stream.concat(lottos.stream(), targetLottos.lottos.stream())
			.collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lottos lottos1 = (Lottos)o;
		return Objects.equals(lottos, lottos1.lottos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottos);
	}
}
