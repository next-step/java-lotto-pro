package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.domain.quantity.Quantity;

public class Lottos {
	private static final int MIN_LOTTOS_SIZE = 1;
	private final List<Lotto> lottos;

	private Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static Lottos from(List<Lotto> lottos) {
		return new Lottos(lottos);
	}

	public Lottos concat(Lottos other) {
		return new Lottos(
			Stream.concat(this.lottos.stream(), other.lottos.stream())
				.collect(Collectors.toList())
		);
	}

	public Quantity getQuantity() {
		return Quantity.from(this.lottos.size());
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}

	public LottoResults toLottoResults(Lotto winLotto, LottoNumber bonusNumber) {
		return LottoResults.from(this.lottos.stream()
			.map(lotto -> LottoResult.from(lotto,
				MatchRank.valueOf(lotto.countMatchCount(winLotto), lotto.contains(bonusNumber))))
			.collect(Collectors.toList()));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lottos lottos = (Lottos)o;
		return Objects.equals(getLottos(), lottos.getLottos());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLottos());
	}
}
