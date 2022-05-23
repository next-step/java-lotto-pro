import lotto.LottoMachine;
import lotto.LottoResult;
import lotto.model.Lottos;
import lotto.model.UserMoney;
import lotto.model.WinningList;
import lotto.model.WinningLotto;
import view.InputView;
import view.ResultView;

public class ApplicationMain {

	public static void main(String[] args) {
		UserMoney userMoney = userMoney();
		LottoMachine lottoMachine = new LottoMachine();

		// 로또금액보다 소지금액이 적은 경우 아래로직을 실행 할 필요가 없음
		if (userMoney.getMoney() < lottoMachine.lottoPrice()) {
			return;
		}

		String buyCount = inputManualLottoCount(userMoney, lottoMachine);
		Lottos writeLotto = inputManualLottoCount(buyCount);

		Lottos manualLottos = lottoMachine.buyManualLottos(userMoney, writeLotto);
		Lottos autoLottos = lottoMachine.buyAutoLottos(userMoney, userMoney.getMoney() / lottoMachine.lottoPrice());

		ResultView.printLottos(manualLottos, autoLottos);

		WinningLotto lastWinningLotto = lastWinningLotto();
		LottoResult lottoResult = new LottoResult(lastWinningLotto, manualLottos, autoLottos);
		WinningList winningList = lottoResult.winningList();
		ResultView.printWinStatistics(winningList);
		ResultView.printProfitRate(lottoResult.profitRate(lottoMachine.lottoPrice()));
	}

	private static UserMoney userMoney() {
		try {
			return InputView.inputMoney();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return userMoney();
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
			WinningLotto lastWinningLotto = InputView.inputWinLottoNumbers();
			String bonusLottoNumber = InputView.inputBonusLottoNumber();
			lastWinningLotto.addBonusLottoNumber(bonusLottoNumber);
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
