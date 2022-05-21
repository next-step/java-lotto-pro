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
		User user = new User(InputView.inputMoney());
		LottoMachine lottoMachine = new LottoMachine();

		String buyCount = InputView.inputManualLottoCount();
		user.isCanBuyLotto(lottoMachine, buyCount);
		Lottos writeLotto = InputView.inputManualLotto(buyCount);
		user.buyManualLottos(lottoMachine, writeLotto);
		user.buyAutoLottos(lottoMachine);
		ResultView.printLottos(user.getManualLottos(), user.getAutoLottos());

		LottoNumbers lastWinningLotto = InputView.inputWinLottoNumbers();
		String bonusLottoNumber = InputView.inputBonusLottoNumber();
		LottoResult lottoResult = new LottoResult(lastWinningLotto, bonusLottoNumber, user.getManualLottos(), user.getAutoLottos());
		
		WinningList winningList = lottoResult.winningList();
		ResultView.printWinStatistics(winningList);
		ResultView.printProfitRate(lottoResult.profitRate(lottoMachine.lottoPrice()));
	}
}
