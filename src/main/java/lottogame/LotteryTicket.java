package lottogame;

import java.util.Collection;
import java.util.List;

public class LotteryTicket {

	private List<Integer> lotteryNumbers;

	private LotteryTicket(List<Integer> lotteryNumber) {
		this.lotteryNumbers = lotteryNumber;
	}

	public static LotteryTicket makeLotteryTicket() {
		return new LotteryTicket(LotteryNumberMaker.makelotteryNumbers());
	}

	public List<Integer> getLotteryNumbers() {
		return lotteryNumbers;
	}
}
