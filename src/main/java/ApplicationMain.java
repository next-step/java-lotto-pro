import lotto.LottoMachine;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.UserMoney;
import lotto.model.WinningList;
import view.InputView;
import view.ResultView;

public class ApplicationMain {

	public static void main(String[] args) {
		UserMoney userMoney = InputView.inputMoney();
		Lottos lottos = new LottoMachine().buyAutoLottos(userMoney);
		ResultView.printLottos(lottos);

		LottoNumbers lastWinningLotto = InputView.inputLastWinLotto();
		WinningList winningList = new WinningList(lottos, lastWinningLotto);
		ResultView.printWinStatistics(winningList);
//		ResultView.printProfitRate(winningList.profitRate(userMoney));
	}
}
