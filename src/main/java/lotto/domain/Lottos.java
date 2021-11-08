package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {
	public static final String LOTTOS_NULL_OR_EMPTY_ERROR = "로또 목록은 null 이나 0개 일 수 없습니다.";

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
			throw new IllegalArgumentException(LOTTOS_NULL_OR_EMPTY_ERROR);
		}
	}
}
