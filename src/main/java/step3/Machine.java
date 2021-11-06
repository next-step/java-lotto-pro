package step3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Machine {

	private final int buyCount;

	public Machine(Money money) {
		assert money != null;
		this.buyCount = money.buyCount();
	}

	public void createLotto() {
		Set<LottoNumbers> lottoPapers = new HashSet<>();
		for (int i = 0; i < buyCount; i++) {
			LottoNumbers lottoNumbers = new LottoNumbers();
			lottoPapers.add(lottoNumbers.createLottoNumbers());
		}
		LottoPapers.createPapers(new ArrayList<>(lottoPapers));
	}
}
