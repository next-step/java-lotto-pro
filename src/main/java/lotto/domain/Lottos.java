package lotto.domain;

import java.util.List;

public class Lottos {
	private final List<Lotto> lottos;

	private Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static Lottos of(List<Lotto> lottos) {
		return new Lottos(lottos);
	}

	public int getSize() {
		return this.lottos.size();
	}

	public List<Lotto> getValues() {
		return this.lottos;
	}
}
