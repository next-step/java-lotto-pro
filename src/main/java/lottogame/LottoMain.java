package lottogame;

public class LottoMain {

	public static void main(String[] args) {
		ResultView.printGuideMessage("구매금액을 입력해주세요.");
		String inputAmount = InputView.readLine();
		LottoTickets lottoTickets = LottoTicketIssuer.buyTickets(inputAmount);
		ResultView.printLottoTickets(lottoTickets);
	}
}
