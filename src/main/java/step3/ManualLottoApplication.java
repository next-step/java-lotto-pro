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
    LottoMatchResult lottoMatchResult = new LottoMatchResult(lottoTickets,
        winningTicket); // 숫자 매칭 결과
    LottoWinningPrice lottoWinningPrice = new LottoWinningPrice(lottoMatchResult); // 당첨금 계산
    ResultView.printWinningPrice(lottoWinningPrice);

    // 수익률 출력
    LottoWinningProfit lottoWinningProfit =
        new LottoWinningProfit(lottoWinningPrice, lottoTicketsPrice); // 수익률 계산
    ResultView.printWinningProfit(lottoWinningProfit.getProfit());
  }
}
