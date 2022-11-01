package lotto.view.output;

import lotto.controller.dto.BoughtLottoResponse;

public class LottoBuyOutputView {
	private static final String BUYING_RESULT_OUTPUT = "수동으로 %s장 자동으로 %s개를 구매했습니다.\n";

	public LottoBuyOutputView() {
	}

	public void printBuyingResult(BoughtLottoResponse boughtLottoTickets) {
		System.out.printf(BUYING_RESULT_OUTPUT,
			boughtLottoTickets.getManualBoughtCount(),
			boughtLottoTickets.getAutoBoughtCount());
		System.out.println(boughtLottoTickets);
	}

}
