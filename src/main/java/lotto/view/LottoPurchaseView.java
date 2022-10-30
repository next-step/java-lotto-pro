package lotto.view;

import lotto.controller.LottoController;
import lotto.controller.dto.PurchasedLottoTicketsResponse;
import money.Money;
import utils.InputHandler;

public class LottoPurchaseView {

	private static final String PURCHASE_PROMPT_OUTPUT = "구입금액을 입력해 주세요.";
	private static final String PURCHASE_RESULT_OUTPUT = "%s개를 구매했습니다.\n";

	private final LottoController lottoController;

	public LottoPurchaseView(LottoController lottoController) {
		this.lottoController = lottoController;
	}

	public PurchasedLottoTicketsResponse purchaseLotto() {
		System.out.println(PURCHASE_PROMPT_OUTPUT);

		PurchasedLottoTicketsResponse lottoTickets = lottoController.quickPick(inputMoneyToPurchase());

		System.out.printf(PURCHASE_RESULT_OUTPUT, lottoTickets.getCount());
		System.out.println(lottoTickets);

		return lottoTickets;
	}

	private Money inputMoneyToPurchase() {
		return Money.wons(InputHandler.inputInteger());
	}
}
