package lotto;

import lotto.domain.LottoStatics;
import lotto.domain.LottoStaticsResult;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.PositiveNumber;
import lotto.domain.Purchase;
import lotto.domain.WinningLotto;
import lotto.dto.PurchaseInfo;
import lotto.dto.WinningInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

	public static void main(String[] args) {
		try {
			PurchaseInfo purchaseInfo = getPurchaseInfo();
			LottoTickets autoTickets = generateAutoTickets(purchaseInfo);
			LottoTickets manualTickets = getManualLottoTickets(purchaseInfo);
			showLottoTicketTotal(autoTickets, manualTickets);
			WinningInfo winningInfo = getWinningInfo();
			LottoTickets totalTickets = getTotalTickets(autoTickets, manualTickets);
			LottoStaticsResult staticsResult = getStaticsResult(winningInfo, purchaseInfo, totalTickets);
			showWinningResult(staticsResult);
		} catch (Exception ex) {
			ResultView.error(ex.getMessage());
		}
	}

	private static LottoTickets getTotalTickets(LottoTickets autoTickets, LottoTickets manualTickets) {
		return LottoTickets.combine(manualTickets, autoTickets);
	}

	private static void showWinningResult(LottoStaticsResult staticsResult) {
		ResultView.showPrize(staticsResult.getRankCount(), staticsResult.getProfit());
	}

	private static LottoStaticsResult getStaticsResult(WinningInfo winningInfo,
		PurchaseInfo purchaseInfo,
		LottoTickets totalTickets) {

		WinningLotto winningLotto = WinningLotto.of(
			winningInfo.getWinningNumbers(),
			winningInfo.getBonusNumber());
		Money purchaseMoney = Money.of(purchaseInfo.getMoney());

		return LottoStatics.calculate(totalTickets
			, winningLotto, purchaseMoney);
	}

	private static WinningInfo getWinningInfo() {
		return InputView.getWinningInfo();
	}

	private static LottoTickets getManualLottoTickets(PurchaseInfo purchaseInfo) {
		return LottoTickets.ofIntList(purchaseInfo.getManualLottoNumbers());
	}

	private static PurchaseInfo getPurchaseInfo() {
		return InputView.getPurchaseInfo();
	}

	private static LottoTickets generateAutoTickets(PurchaseInfo purchaseInfo) {
		Money money = Money.of(purchaseInfo.getMoney());
		PositiveNumber manualTicketCount = PositiveNumber.of(purchaseInfo.getManualLottoNumbers().size());
		PositiveNumber autoLottoCount = getAutoLottoCount(money, manualTicketCount.toInt());
		return LottoTicketGenerator.generateByCount(autoLottoCount);
	}

	private static PositiveNumber getAutoLottoCount(Money purchaseMoney, int manualTicketSize) {
		PositiveNumber autoLottoCount = Purchase.calculateCount(purchaseMoney);
		autoLottoCount = autoLottoCount.minus(manualTicketSize);
		return autoLottoCount;
	}

	private static void showLottoTicketTotal(LottoTickets autoTickets, LottoTickets manualTickets) {
		LottoTickets totalTickets = LottoTickets.combine(manualTickets, autoTickets);
		ResultView.showLottoNumbers(manualTickets.getSize(), autoTickets.getSize(), totalTickets);
	}
}
