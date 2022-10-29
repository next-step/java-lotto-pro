package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.LottoVendor;
import money.Money;
import utils.InputHandler;

public class LottoPurchaseView {

	private static final String PURCHASE_PROMPT_OUTPUT = "구입금액을 입력해 주세요.";
	private static final String PURCHASE_RESULT_OUTPUT = "%s개를 구매했습니다.\n";

	private final LottoVendor lottoVendor;

	public LottoPurchaseView(LottoVendor lottoVendor) {
		this.lottoVendor = lottoVendor;
	}

	public LottoTickets purchaseLotto() {
		System.out.println(PURCHASE_PROMPT_OUTPUT);

		LottoTickets lottoTickets = lottoVendor.quickPick(inputMoneyToPurchase());

		System.out.printf(PURCHASE_RESULT_OUTPUT, lottoTickets.getCount());
		System.out.println(lottoTickets);

		return lottoTickets;
	}

	private Money inputMoneyToPurchase() {
		return Money.wons(InputHandler.inputInteger());
	}
}
