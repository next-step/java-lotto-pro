package lotto.model;

import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class Lottos implements Iterable<Lotto> {

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
	public Iterator<Lotto> iterator() {
		return lottos.iterator();
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");

		for (Lotto lotto : lottos) {
			joiner.add(lotto.toString());
		}

		return joiner.toString();
	}
}
