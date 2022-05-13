import lotto.Lotto;
import lotto.model.UserMoney;
import lotto.model.WinningList;

public class ApplicationMain {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		String money = lotto.inputMessage("구입금액을 입력해 주세요.");
		UserMoney userMoney = new UserMoney(money);
		lotto.buyAutoLotto(userMoney);
		WinningList winningList = lotto.winningList();
		lotto.printWinStatistics(winningList);
		lotto.printProfitRate(winningList, userMoney);
	}
}
