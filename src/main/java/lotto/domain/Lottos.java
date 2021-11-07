package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {

	public static final String JOIN_DELIMITER = "\n";
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottoList) {
		this.lottos = Collections.unmodifiableList(lottoList);
	}

	public int quantity() {
		return lottos.size();
	}

	@Override
	public String toString() {
		return String.join(JOIN_DELIMITER, lottos.toString());
	}
}
