package lotto.view;

import java.util.List;

import lotto.controller.LottoController;
import lotto.controller.dto.BoughtLottoTicketsResponse;
import utils.InputHandler;

public class LottoBuyingView {
	private static final String BUYING_MONEY_PROMPT = "구입금액을 입력해 주세요.";
	private static final String BUYING_RESULT_OUTPUT = "수동으로 %s장 자동으로 %s개를 구매했습니다.\n";
	private static final String BUYING_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String BUYING_MANUAL_LOTTO_PROMPT = "수동으로 구매할 번호를 입력해 주세요.";

	private final LottoController lottoController;

	public LottoBuyingView(LottoController lottoController) {
		this.lottoController = lottoController;
	}

	public BoughtLottoTicketsResponse buyLottoTickets() {
		int buyingLottoTicketsAmount = getMoneyToBuyLottoTickets();

		List<List<Integer>> manualLottoTickets = getManualLottoTickets();

		BoughtLottoTicketsResponse boughtLottoTickets = lottoController.buyLottoTickets(buyingLottoTicketsAmount,
			manualLottoTickets);

		System.out.printf(BUYING_RESULT_OUTPUT, boughtLottoTickets.getManualBoughtCount(),
			boughtLottoTickets.getAutoBoughtCount());
		System.out.println(boughtLottoTickets);

		return boughtLottoTickets;
	}

	private int getMoneyToBuyLottoTickets() {
		return InputHandler.inputInteger(BUYING_MONEY_PROMPT);
	}

	private List<List<Integer>> getManualLottoTickets() {
		int buyingManualLottoCount = InputHandler.inputInteger(BUYING_MANUAL_LOTTO_COUNT);

		return InputHandler.inputIntegerListMany(BUYING_MANUAL_LOTTO_PROMPT, buyingManualLottoCount);
	}
}
