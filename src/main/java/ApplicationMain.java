import java.util.List;

import lotto.LottoMachine;
import lotto.LottoResult;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.WinningList;
import lotto.model.WinningLotto;
import view.InputView;
import view.ResultView;

public class ApplicationMain {

	public static void main(String[] args) {
		LottoMachine lottoMachine = new LottoMachine();
		int userCoin = userCoin(lottoMachine);

		int manualLottosBuyCount = inputManualLottoCount(userCoin, lottoMachine);
		List<LottoNumbers> writeLotto = inputManualLottoCount(manualLottosBuyCount);
		Lottos lottos = lottoMachine.buyLottos(userCoin, writeLotto);

		ResultView.printLottos(lottos, manualLottosBuyCount);

		WinningLotto lastWinningLotto = lastWinningLotto();
		LottoResult lottoResult = new LottoResult(lastWinningLotto, lottos);
		WinningList winningList = lottoResult.winningList();
		ResultView.printWinStatistics(winningList);
		ResultView.printProfitRate(lottoResult.profitRate(lottoMachine.lottoPrice()));
	}

	private static int userCoin(LottoMachine lottoMachine) {
		try {
			return InputView.inputMoney(lottoMachine);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return userCoin(lottoMachine);
		}
	}

	private static int inputManualLottoCount(int userCoin, LottoMachine lottoMachine) {
		try {
			return InputView.inputManualLottoCount(userCoin, lottoMachine);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return inputManualLottoCount(userCoin, lottoMachine);
		}
	}

	private static WinningLotto lastWinningLotto() {
		try {
			LottoNumbers lastWinningLottoNumbers = InputView.inputWinLottoNumbers();
			String bonusLottoNumber = InputView.inputBonusLottoNumber();
			WinningLotto lastWinningLotto = new WinningLotto(lastWinningLottoNumbers, bonusLottoNumber);
			return lastWinningLotto;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return lastWinningLotto();
		}
	}

	private static List<LottoNumbers> inputManualLottoCount(int buyCount) {
		try {
			return InputView.inputManualLotto(buyCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return inputManualLottoCount(buyCount);
		}
	}
}
