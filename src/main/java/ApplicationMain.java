import lotto.LottoMachine;
import lotto.LottoResult;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.UserMoney;
import lotto.model.WinningList;
import view.InputView;
import view.ResultView;

public class ApplicationMain {

	public static void main(String[] args) {
		UserMoney userMoney = InputView.inputMoney();

		LottoMachine lottoMachine = new LottoMachine();
		Lottos lottos = lottoMachine.buyAutoLottos(userMoney);
		ResultView.printLottos(lottos);

		LottoNumbers lastWinningLotto = InputView.inputLastWinLotto();
		String bonusLottoNumber = InputView.inputBonusLottoNumber();
		LottoResult lottoResult = new LottoResult(lottos, lastWinningLotto, bonusLottoNumber);
		WinningList winningList = lottoResult.winningList();
		ResultView.printWinStatistics(winningList);
		ResultView.printProfitRate(lottoResult.profitRate(lottoMachine.lottoPrice()));
	}
}
