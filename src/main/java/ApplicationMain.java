import lotto.LottoMachine;
import lotto.LottoResult;
import lotto.User;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.WinningList;
import view.InputView;
import view.ResultView;

public class ApplicationMain {

	public static void main(String[] args) {
		User user = newUser();
		LottoMachine lottoMachine = new LottoMachine();

		// 로또금액보다 소지금액이 적은 경우 아래로직을 실행 할 필요가 없음
		if (user.getUserMoney().getMoney() < lottoMachine.lottoPrice()) {
			return;
		}

		String buyCount = inputManualLottoCount(user, lottoMachine);
		Lottos writeLotto = inputManualLottoCount(buyCount);
		user.buyManualLottos(lottoMachine, writeLotto);
		user.buyAutoLottos(lottoMachine);
		ResultView.printLottos(user.getManualLottos(), user.getAutoLottos());

		LottoResult lottoResult = lastWinningLotto(user);

		WinningList winningList = lottoResult.winningList();
		ResultView.printWinStatistics(winningList);
		ResultView.printProfitRate(lottoResult.profitRate(lottoMachine.lottoPrice()));
	}

	private static User newUser() {
		try {
			return new User(InputView.inputMoney());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return newUser();
		}
	}

	private static String inputManualLottoCount(User user, LottoMachine lottoMachine) {
		try {
			return InputView.inputManualLottoCount(user, lottoMachine);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return inputManualLottoCount(user, lottoMachine);
		}
	}

	private static LottoResult lastWinningLotto(User user) {
		try {
			LottoNumbers lastWinningLotto = InputView.inputWinLottoNumbers();
			String bonusLottoNumber = InputView.inputBonusLottoNumber();
			return new LottoResult(lastWinningLotto, bonusLottoNumber, user.getManualLottos(), user.getAutoLottos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return lastWinningLotto(user);
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
