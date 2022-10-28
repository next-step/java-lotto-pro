package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(int purchaseAmount) {
		int quantity = purchaseAmount / Lotto.PRICE;
		this.lottos = IntStream.range(0, quantity)
			.mapToObj(i -> new Lotto(new RandomLottoNumberStrategy()))
			.collect(Collectors.toList());
	}

	public Lottos(String purchaseAmount) {
		this(parseInt(purchaseAmount));
	}

	private static int parseInt(String purchaseAmount) {
		try {
			return Integer.parseInt(purchaseAmount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}
	}

	public long getQuantity() {
		return this.lottos.size();
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}
}
