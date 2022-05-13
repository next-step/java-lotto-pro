import lotto.Lotto;
import lotto.model.UserMoney;
import lotto.model.WinningList;
import view.InputView;
import view.ResultView;

public class ApplicationMain {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		
		String money = InputView.inputMoney();
		UserMoney userMoney = new UserMoney(money);
		ResultView.printLottos(lotto.buyAutoLotto(userMoney));
		
		String lastWinLotto = InputView.inputLastWinLotto();
		WinningList winningList = lotto.winningList(lastWinLotto);
		ResultView.printWinStatistics(winningList);
		ResultView.printProfitRate(lotto.printProfitRate(winningList, userMoney));
	}
}
