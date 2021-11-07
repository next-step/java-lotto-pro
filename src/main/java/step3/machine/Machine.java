package step3.machine;

import step3.LottoPapers;
import step3.Money;

public interface Machine {
	void insertMoney(Money money);
	LottoPapers createLottoPapers();
}
