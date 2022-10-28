package view;

import java.util.Scanner;

import lotto.AutoLottoNumberGenerator;
import lotto.LottoTicket;
import lotto.LottoTickets;
import lotto.LottoVendor;
import money.Money;

public class LottoApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		LottoPurchaseView lottoPurchaseView = new LottoPurchaseView(
			scanner,
			new LottoVendor(Money.wons(1000), new AutoLottoNumberGenerator()));

		LastWeekWinLottoTicketView lastWeekWinLottoTicketView = new LastWeekWinLottoTicketView(scanner);

		LottoWinResultView lottoWinResultView = new LottoWinResultView();

		LottoTickets purchaseLottoTickets = lottoPurchaseView.purchaseLotto();

		LottoTicket lastWeekWinLottoTicket = lastWeekWinLottoTicketView.getLastWeekWinLotto();

		lottoWinResultView.getResult(purchaseLottoTickets, lastWeekWinLottoTicket);
	}
}
