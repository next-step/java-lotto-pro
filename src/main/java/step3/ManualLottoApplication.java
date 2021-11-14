package step3;

import step3.domain.LottoMatchResult;
import step3.domain.LottoTicket;
import step3.domain.LottoTickets;
import step3.domain.LottoTicketsPrice;
import step3.domain.LottoWinningPrice;
import step3.domain.LottoWinningProfit;
import step3.view.InputView;
import step3.view.ResultView;

public class ManualLottoApplication {

  public static void main(String[] args) {
    // 구입 금액 입력
    LottoTicketsPrice lottoTicketsPrice = new LottoTicketsPrice(InputView.getPurchasePriceInput());

    // 구매 갯수 출럭
    int ticketCount = lottoTicketsPrice.getTicketCount();
    ResultView.printTicketCount(ticketCount);

    // 로또 티켓 내용 출력
    LottoTickets lottoTickets = new LottoTickets(ticketCount);
    ResultView.printTickets(lottoTickets);

    // 당첨 번호 입력
    LottoTicket winningTicket = new LottoTicket(InputView.getWinningNumbersInput());

    // 당첨 결과 출력
    LottoMatchResult lottoMatchResult = lottoTickets.matchWinningNumbers(winningTicket);
    LottoWinningPrice lottoWinningPrice = lottoMatchResult.getLottoWinningPrice();
    ResultView.printWinningPrice(lottoMatchResult);

    // 수익률 출력
    LottoWinningProfit lottoWinningProfit = lottoWinningPrice.getWinningProfit(lottoTicketsPrice);
    ResultView.printWinningProfit(lottoWinningProfit.getProfit());
  }
}
