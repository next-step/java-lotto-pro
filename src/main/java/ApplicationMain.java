import lotto.LottoMachine;
import lotto.LottoResult;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.UserMoney;
import lotto.model.WinningList;
import lotto.model.WinningLotto;
import view.InputView;
import view.ResultView;

public class ApplicationMain {

	public static void main(String[] args) {
		LottoMachine lottoMachine = new LottoMachine();
		UserMoney userMoney = userMoney(lottoMachine.lottoPrice());

		String manualLottosBuyCount = inputManualLottoCount(userMoney, lottoMachine);

		Lottos writeLotto = inputManualLottoCount(manualLottosBuyCount);
		Lottos manualLottos = lottoMachine.buyManualLottos(userMoney, writeLotto);
		userMoney = new UserMoney(
				String.valueOf(userMoney.getMoney() - manualLottos.size() * lottoMachine.lottoPrice()),
				lottoMachine.lottoPrice());
		Lottos autoLottos = lottoMachine.buyAutoLottos(userMoney, userMoney.getMoney() / lottoMachine.lottoPrice());

		ResultView.printLottos(manualLottos, autoLottos);

		WinningLotto lastWinningLotto = lastWinningLotto();
		LottoResult lottoResult = new LottoResult(lastWinningLotto, manualLottos, autoLottos);
		WinningList winningList = lottoResult.winningList();
		ResultView.printWinStatistics(winningList);
		ResultView.printProfitRate(lottoResult.profitRate(lottoMachine.lottoPrice()));
	}

	private static UserMoney userMoney(int lottoPrice) {
		try {
			return InputView.inputMoney(lottoPrice);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return userMoney(lottoPrice);
		}
	}

	private static String inputManualLottoCount(UserMoney userMoney, LottoMachine lottoMachine) {
		try {
			return InputView.inputManualLottoCount(userMoney, lottoMachine);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return inputManualLottoCount(userMoney, lottoMachine);
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

	private static Lottos inputManualLottoCount(String buyCount) {
		try {
			return InputView.inputManualLotto(buyCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return inputManualLottoCount(buyCount);
		}
	}
}
