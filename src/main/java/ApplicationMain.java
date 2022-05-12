import lotto.Lotto;

public class ApplicationMain {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.buyAutoLotto();
		lotto.printWinningData();
		lotto.printProfitRate();
	}
}
