package step3.machine;

import step3.lotto.LottoPapers;
import step3.Money;

public interface Machine {
	LottoPapers createLottoPapers(Money money);
}
