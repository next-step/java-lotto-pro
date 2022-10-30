package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lottos {
	private final List<Lotto> lottos;

	private Lottos(LottoPurchaseStrategy lottoPurchaseStrategy) {
		this.lottos = lottoPurchaseStrategy.purchase();
	}

	public static Lottos from(LottoPurchaseStrategy lottoPurchaseStrategy) {
		return new Lottos(lottoPurchaseStrategy);
	}

	public static Lottos purchase(String purchaseAmount) {
		return new Lottos(new DefaultPurchaseStrategy(purchaseAmount));
	}

	public long getQuantity() {
		return this.lottos.size();
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lottos lottos1 = (Lottos)o;
		return Objects.equals(getLottos(), lottos1.getLottos());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLottos());
	}
}
