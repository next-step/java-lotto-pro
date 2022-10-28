package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(final List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public Ranks match(final Lotto winnerLotto) {
		return lottos.stream()
			.mapToInt(lotto -> lotto.match(winnerLotto))
			.mapToObj(Rank::from)
			.collect(Collectors.collectingAndThen(Collectors.toList(), Ranks::new));
	}

	public int size() {
		return lottos.size();
	}
}
