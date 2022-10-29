package view;

import java.util.Scanner;

import lotto.AutoLottoNumberGenerator;
import lotto.LottoTicket;
import lotto.LottoTickets;
import lotto.LottoVendor;
import money.Money;

public class LottoApplication {

	private static final Money LOTTO_PRICE = Money.wons(1000);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		LottoPurchaseView lottoPurchaseView = new LottoPurchaseView(
			scanner,
			new LottoVendor(LOTTO_PRICE, new AutoLottoNumberGenerator()));

		LastWeekWinLottoTicketView lastWeekWinLottoTicketView = new LastWeekWinLottoTicketView(scanner);

		LottoWinResultView lottoWinResultView = new LottoWinResultView(LOTTO_PRICE);

		LottoTickets purchaseLottoTickets = lottoPurchaseView.purchaseLotto();

		LottoTicket lastWeekWinLottoTicket = lastWeekWinLottoTicketView.getLastWeekWinLotto();

		lottoWinResultView.getResult(purchaseLottoTickets, lastWeekWinLottoTicket);
	}
}
