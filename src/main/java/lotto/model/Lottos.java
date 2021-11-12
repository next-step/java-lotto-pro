package lotto.model;

import java.util.LinkedList;
import java.util.List;
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

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");

		for (Lotto lotto : lottos) {
			joiner.add(lotto.toString());
		}

		return joiner.toString();
	}

	public Prize winPrize(WinLotto winLotto) {
		List<Rank> ranks = new LinkedList<>();
		for (Lotto lotto : lottos) {
			ranks.add(winLotto.compare(lotto));
		}
		return Prize.withRankList(ranks);
	}
}
