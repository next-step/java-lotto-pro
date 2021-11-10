package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(final List<Lotto> lottos) {
		this.lottos = new ArrayList<>(lottos);
	}

	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}

	public Stream<Lotto> stream() {
		return lottos.stream();
	}

	public int size() {
		return lottos.size();
	}
}
