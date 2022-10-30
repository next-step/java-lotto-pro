package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerFactory;
import lotto.controller.dto.PurchasedLottoTicketsResponse;
import lotto.controller.dto.WinningLottoTicketResponse;
import lotto.view.LastWeekWinLottoTicketView;
import lotto.view.LottoPurchaseView;
import lotto.view.LottoWinResultView;

public class LottoApplication {

	private static final LottoController lottoController = LottoControllerFactory.createLottoController();

	public static void main(String[] args) {
		LottoPurchaseView lottoPurchaseView = createLottoPurchaseView();
		LastWeekWinLottoTicketView lastWeekWinLottoTicketView = createLastWeekWinLottoTicketView();
		LottoWinResultView lottoWinResultView = createLottoWinResultView();

		PurchasedLottoTicketsResponse purchaseLottoTickets = lottoPurchaseView.purchaseLotto();
		WinningLottoTicketResponse lastWeekWinLottoTicket = lastWeekWinLottoTicketView.getLastWeekWinLotto();

		lottoWinResultView.printWinResult(purchaseLottoTickets, lastWeekWinLottoTicket);
	}

	private static LottoWinResultView createLottoWinResultView() {
		return new LottoWinResultView(lottoController);
	}

	private static LastWeekWinLottoTicketView createLastWeekWinLottoTicketView() {
		return new LastWeekWinLottoTicketView(lottoController);
	}

	private static LottoPurchaseView createLottoPurchaseView() {
		return new LottoPurchaseView(lottoController);
	}
}
