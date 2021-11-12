package step3.machine;

import java.util.List;

import step3.lotto.LottoPapers;

public interface Machine {
	LottoPapers createLottoPapers(int buyCount);

	LottoPapers createManualLottoPapers(List<String> strings);
}
