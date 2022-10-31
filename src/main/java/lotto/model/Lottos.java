package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(final List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public Ranks match(final Winner winner) {
		return lottos.stream()
			.map(winner::match)
			.collect(Collectors.collectingAndThen(Collectors.toList(), Ranks::new));
	}

	public long countByType(final LottoType type) {
		return lottos.stream()
			.filter(lotto -> lotto.isTypeOf(type))
			.count();
	}

	public Money getTotalSpent() {
		return Lotto.LOTTO_PRICE.multiply(lottos.size());
	}

	public Lottos merge(final Lottos otherLotto) {
		List<Lotto> result = new ArrayList<>();
		result.addAll(this.lottos);
		result.addAll(otherLotto.lottos);
		return new Lottos(result);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Lottos lottos1 = (Lottos)o;
		return Objects.equals(lottos, lottos1.lottos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottos);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (final Lotto lotto : lottos) {
			sb.append(lotto);
			sb.append("\n");
		}
		return sb.toString();
	}
}
