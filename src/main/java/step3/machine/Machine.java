package step3.machine;

import step3.LottoPapers;
import step3.Money;

public interface Machine {
	LottoPapers createLottoPapers(Money money);
}
