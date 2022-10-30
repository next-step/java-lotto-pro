package lotto.view;

import java.util.List;

import lotto.controller.LottoController;
import lotto.controller.dto.BoughtLottoTicketsResponse;
import utils.ExceptionHandler;
import utils.InputHandler;

public class LottoBuyingView {
	private static final String BUYING_MONEY_PROMPT = "구입금액을 입력해 주세요.";
	private static final String BUYING_RESULT_OUTPUT = "수동으로 %s장 자동으로 %s개를 구매했습니다.\n";
	private static final String BUYING_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String BUYING_MANUAL_LOTTO_PROMPT = "수동으로 구매할 번호를 입력해 주세요.";

	private final LottoController lottoController;
	private final InputHandler inputHandler;

	public LottoBuyingView(LottoController lottoController, InputHandler inputHandler) {
		this.lottoController = lottoController;
		this.inputHandler = inputHandler;
	}

	public BoughtLottoTicketsResponse buyLottoTickets() {
		BoughtLottoTicketsResponse boughtLottoTickets = ExceptionHandler.callWithHandlingException(
			this::buyLottoTicketsWithHandlingException);

		printBuyingResult(boughtLottoTickets);

		return boughtLottoTickets;
	}

	private BoughtLottoTicketsResponse buyLottoTicketsWithHandlingException() {
		int buyingLottoTicketsMoney = getMoneyToBuyLottoTickets();

		List<List<Integer>> manualLottoTickets = getManualLottoTickets();

		return lottoController.buyLottoTickets(buyingLottoTicketsMoney, manualLottoTickets);
	}

	private void printBuyingResult(BoughtLottoTicketsResponse boughtLottoTickets) {
		System.out.printf(BUYING_RESULT_OUTPUT,
			boughtLottoTickets.getManualBoughtCount(),
			boughtLottoTickets.getAutoBoughtCount());
		System.out.println(boughtLottoTickets);
	}

	private int getMoneyToBuyLottoTickets() {
		return inputHandler.inputPositiveInteger(BUYING_MONEY_PROMPT);
	}

	private List<List<Integer>> getManualLottoTickets() {
		int buyingManualLottoCount = inputHandler.inputPositiveInteger(BUYING_MANUAL_LOTTO_COUNT);

		return inputHandler.inputPositiveIntegerListMany(BUYING_MANUAL_LOTTO_PROMPT, buyingManualLottoCount);
	}
}
