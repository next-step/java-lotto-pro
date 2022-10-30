package lotto;

import java.util.List;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerFactory;
import lotto.controller.dto.BoughtLottoTicketsResponse;
import lotto.view.LastWeekWinLottoTicketView;
import lotto.view.LottoBuyingView;
import lotto.view.LottoWinResultView;

public class LottoApplication {

	private static final LottoController lottoController = LottoControllerFactory.createLottoController();

	public static void main(String[] args) {
		LottoBuyingView lottoBuyingView = createLottoBuyingView();
		LastWeekWinLottoTicketView lastWeekWinLottoTicketView = createLastWeekWinLottoTicketView();
		LottoWinResultView lottoWinResultView = createLottoWinResultView();

		BoughtLottoTicketsResponse boughtLottoTickets = lottoBuyingView.buyLottoTickets();
		List<Integer> lastWeekWinLottoTicket = lastWeekWinLottoTicketView.getLastWeekWinLotto();

		lottoWinResultView.printWinResult(boughtLottoTickets, lastWeekWinLottoTicket);
	}

	private static LottoWinResultView createLottoWinResultView() {
		return new LottoWinResultView(lottoController);
	}

	private static LastWeekWinLottoTicketView createLastWeekWinLottoTicketView() {
		return new LastWeekWinLottoTicketView();
	}

	private static LottoBuyingView createLottoBuyingView() {
		return new LottoBuyingView(lottoController);
	}
}
