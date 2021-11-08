package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

	public static final String JOIN_DELIMITER = "\n";
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottoList) {
		this.lottos = Collections.unmodifiableList(lottoList);
	}

	public int quantity() {
		return lottos.size();
	}

	public List<Rank> match(Lotto standardLotto) {
		return lottos.stream()
			.map(lotto -> standardLotto.match(lotto))
			.collect(Collectors.toList());
	}
	@Override
	public String toString() {
		return lottos.stream()
			.map(lotto -> lotto.toString()+JOIN_DELIMITER)
			.collect(Collectors.joining());
	}
}
