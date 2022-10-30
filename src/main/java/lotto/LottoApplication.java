package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerFactory;
import lotto.controller.dto.BoughtLottoTicketsResponse;
import lotto.view.LottoBuyingView;
import lotto.view.LottoWinResultView;

public class LottoApplication {

	private static final LottoController lottoController = LottoControllerFactory.createLottoController();

	public static void main(String[] args) {
		LottoBuyingView lottoBuyingView = createLottoBuyingView();
		LottoWinResultView lottoWinResultView = createLottoWinResultView();

		BoughtLottoTicketsResponse boughtLottoTickets = lottoBuyingView.buyLottoTickets();

		lottoWinResultView.printWinResult(boughtLottoTickets);
	}

	private static LottoWinResultView createLottoWinResultView() {
		return new LottoWinResultView(lottoController);
	}

	private static LottoBuyingView createLottoBuyingView() {
		return new LottoBuyingView(lottoController);
	}
}
