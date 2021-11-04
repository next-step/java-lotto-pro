package lottogame;

public class LotteryTicket {

	private LotteryNumberGroup lotteryNumberGroup;

	private LotteryTicket(LotteryNumberGroup lotteryNumber) {
		this.lotteryNumberGroup = lotteryNumber;
	}

	public static LotteryTicket makeLotteryTicket() {
		return new LotteryTicket(LotteryNumberMaker.makelotteryNumbers());
	}

	public LotteryNumberGroup getLotteryNumberGroup() {
		return lotteryNumberGroup;
	}

	public int numOfNumbersInGroup(){
		return lotteryNumberGroup.getLotteryNumbers().size();
	}
}
