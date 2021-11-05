package step3;

import java.util.HashSet;
import java.util.Set;

public class Machine {
	private Set<LottoNumbers> lottoPapers;
	private final int buyCount;

	public Machine(Money money) {
		assert money != null;
		this.buyCount = money.buyCount();
	}

	public Set<LottoNumbers> createLotto() {
		lottoPapers = new HashSet<>();
		for (int i = 0; i < buyCount; i++) {
			LottoNumbers lottoNumbers = new LottoNumbers();
			lottoPapers.add(lottoNumbers.createLottoNumbers());
		}
		return lottoPapers;
	}
}
