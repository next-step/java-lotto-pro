package lottogame;

import java.util.List;

public class LotteryTicket {

	private List<Integer> lotteryNumbers;

	public LotteryTicket(List<Integer> lotteryNumber) {
		this.lotteryNumbers = lotteryNumber;
	}

	public List<Integer> getLotteryNumbers() {
		return lotteryNumbers;
	}
}
