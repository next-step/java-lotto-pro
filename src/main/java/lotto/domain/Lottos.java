package lotto.domain;

import java.util.Collections;
import java.util.List;

import lotto.domain.exception.LottosNotCollectableException;

public class Lottos {

	private final List<Lotto> lottos;

	private Lottos(final List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static Lottos from(final List<Lotto> lottos) {
		validateNotNullOrEmpty(lottos);

		return new Lottos(lottos);
	}

	public int size() {
		return lottos.size();
	}

	public List<Lotto> lottos() {
		return Collections.unmodifiableList(lottos);
	}

	private static void validateNotNullOrEmpty(List<Lotto> lottos) {
		if (lottos == null || lottos.size() == 0) {
			throw new LottosNotCollectableException();
		}
	}
}
