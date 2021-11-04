package lottogame;

import java.util.List;

public class LotteryNumberGroup {
	private List<LotterNumber> lotteryNumbers;

	public LotteryNumberGroup(List<LotterNumber> lotteryNumbers) {
		this.lotteryNumbers = lotteryNumbers;
	}

	public List<LotterNumber> getLotteryNumbers() {
		return lotteryNumbers;
	}
}
