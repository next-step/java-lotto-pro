package view;

import java.math.BigDecimal;
import java.util.Scanner;

import lotto.LottoTickets;
import lotto.LottoVendor;
import money.Money;

public class InputView {

	private final static String PURCHASE_PROMPT_OUTPUT = "구입금액을 입력해 주세요.";
	private final static String PURCHASE_RESULT_OUTPUT = "%s개를 구매했습니다.\n";

	private final Scanner scanner;
	private final LottoVendor lottoVendor;

	public InputView(Scanner scanner, LottoVendor lottoVendor) {
		this.scanner = scanner;
		this.lottoVendor = lottoVendor;
	}

	public void runLottoVendor() {
		System.out.println(PURCHASE_PROMPT_OUTPUT);

		LottoTickets lottoTickets = lottoVendor.purchase(inputMoneyToPurchase());

		System.out.printf(PURCHASE_RESULT_OUTPUT, lottoTickets.getCount());
		System.out.println(lottoTickets);
	}

	private Money inputMoneyToPurchase() {
		return Money.wons(toBigDecimal(scanner.next()));
	}

	private BigDecimal toBigDecimal(String input) {
		return new BigDecimal(input);
	}
}
