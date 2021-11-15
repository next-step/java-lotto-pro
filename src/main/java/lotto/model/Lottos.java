package lotto.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import lotto.constants.Rank;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		if (lottos == null || lottos.size() == 0) {
			throw new IllegalArgumentException("Lotto is empty.");
		}
		this.lottos = lottos;
	}

	public int size() {
		return lottos.size();
	}

	public Lottos merge(Lottos lottos) {
		List<Lotto> merged = new LinkedList<>(this.lottos);
		merged.addAll(lottos.lottos);
		return new Lottos(merged);
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");

		for (Lotto lotto : lottos) {
			joiner.add(lotto.toString());
		}

		return joiner.toString();
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
  
	public Prize winPrize(WinLotto winLotto) {
		List<Rank> ranks = new LinkedList<>();
		for (Lotto lotto : lottos) {
			ranks.add(winLotto.compare(lotto));
		}
		return Prize.withRankList(ranks);
	}
}
