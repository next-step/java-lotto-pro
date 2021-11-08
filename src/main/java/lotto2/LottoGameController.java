package lotto2;

import lotto2.domain.LottoStaticsResult;
import lotto2.domain.LottoTicketGenerator;
import lotto2.domain.LottoTickets;
import lotto2.domain.Money;
import lotto2.domain.PositiveNumber;
import lotto2.domain.Purchase;
import lotto2.domain.WinningLotto;
import lotto2.dto.PurchaseReqDto;
import lotto2.dto.PurchaseResDto;
import lotto2.dto.WinningReqDto;
import lotto2.view.InputView;
import lotto2.view.ResultView;

public class LottoGameController {

	public static void main(String[] args) {
		try {
			PurchaseResDto purchaseResDto = purchaseLotto();
			showWinningResult(purchaseResDto);
		} catch (IllegalArgumentException ex) {
			ResultView.error(ex.getMessage());
		}
	}

	private static PurchaseResDto purchaseLotto() {
		PurchaseReqDto purchaseReqDto = InputView.getPurchaseInfo();
		Money purchaseMoney = Money.of(purchaseReqDto.getMoney());

		LottoTickets manualTickets = LottoTickets.ofIntList(purchaseReqDto.getManualLottoNumbers());

		PositiveNumber autoLottoCount = getAutoLottoCount(purchaseMoney, manualTickets.getSize());
		LottoTickets autoLottoTickets = LottoTicketGenerator.generateByCount(autoLottoCount);
		LottoTickets totalTickets = LottoTickets.combine(manualTickets, autoLottoTickets);

		ResultView.showLottoNumbers(manualTickets.getSize(), autoLottoTickets.getSize(), totalTickets);

		return new PurchaseResDto(totalTickets, purchaseReqDto.getMoney());

	}

	private static void showWinningResult(PurchaseResDto dto) {

		WinningReqDto winningReqDto = InputView.getWinningInfo();

		WinningLotto winningLotto = WinningLotto.of(
			winningReqDto.getWinningNumbers(),
			winningReqDto.getBonusNumber());
		Money purchaseMoney = Money.of(dto.getPurchaseMoney());

		LottoStaticsResult lottoStaticsResult = LottoStaticsResult.calculate(dto.getTotalTickets()
			, winningLotto, purchaseMoney);

		ResultView.showPrize(lottoStaticsResult.getRankCount(), lottoStaticsResult.getProfit());
	}

	private static PositiveNumber getAutoLottoCount(Money purchaseMoney, int manualTicketSize) {
		PositiveNumber autoLottoCount = Purchase.calculateCount(purchaseMoney);
		autoLottoCount.minus(manualTicketSize);
		return autoLottoCount;
	}

}
