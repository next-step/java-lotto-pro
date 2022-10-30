package lotto.model;

import java.util.List;
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

	public int size() {
		return lottos.size();
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
