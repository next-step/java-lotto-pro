package lotto;

import exception.BusinessException;
import investment.Investment;
import view.InputView;
import view.ResultView;

public class PlayGame {

	public void play() {
		//구입금액 입력
		Investment investment = getInvestment();

		//수동 로또 갯수 입력
		ManualCount manualCount = getManualCount();
		LottoList lottoList = getManualLottoList(manualCount);

		//수동 제외한 로또생성
		int autoCount = investment.getAutoCount(manualCount);
		lottoList.addAll(new LottoList(autoCount));

		ResultView.purchaseResult(manualCount.size(), autoCount, lottoList);
		Lotto winnerNumber = getWinnerNumber();
		BonusBall bonusBall = getBonusBall();

		//결과 확인
		Winning winning = lottoList.getWinningResult(winnerNumber, bonusBall);
		ResultView.totalResult(winning, investment);
	}

	private Investment getInvestment() {
		try {
			//투자금
			String inputInvestment = InputView.inputInvestment();
			return new Investment(inputInvestment);
		} catch (BusinessException e) {
			ResultView.print(e.getMessage());
			return getInvestment();
		}
	}

	private ManualCount getManualCount() {
		try {
			String inputManualCount = InputView.inputManualCount();
			return new ManualCount(inputManualCount);
		} catch (BusinessException e) {
			ResultView.print(e.getMessage());
			return getManualCount();
		}
	}

	private LottoList getManualLottoList(ManualCount manualCount) {
		LottoList manualLottoList = new LottoList();
		if (manualCount.size() == 0) {
			return manualLottoList;
		}
		manualLottoList.addLottoList(getManualLotto());
		for (int i = 1; i < manualCount.size(); i++) {
			manualLottoList.addLottoList(getManualLottoNoMessage());
		}
		return manualLottoList;
	}

	private Lotto getManualLotto() {
		try {
			String inputManualNumber = InputView.inputManualNumber();
			return new Lotto(inputManualNumber);
		} catch (BusinessException e) {
			ResultView.print(e.getMessage());
			return getManualLotto();
		}
	}

	private Lotto getManualLottoNoMessage() {
		try {
			String inputManualNumberNoMessage = InputView.inputManualNumberNoMessage();
			return new Lotto(inputManualNumberNoMessage);
		} catch (BusinessException e) {
			ResultView.print(e.getMessage());
			return getManualLottoNoMessage();
		}
	}

	private Lotto getWinnerNumber() {
		try {
			//당첨번호
			String inputWinningNumber = InputView.inputWinningNumber();
			return new Lotto(inputWinningNumber);
		} catch (BusinessException e) {
			ResultView.print(e.getMessage());
			return getWinnerNumber();
		}
	}

	private BonusBall getBonusBall() {
		try {
			//보너스 번호
			String inputBonusBall = InputView.inputBonusBall();
			return new BonusBall(inputBonusBall);
		} catch (BusinessException e) {
			ResultView.print(e.getMessage());
			return getBonusBall();
		}
	}
}
