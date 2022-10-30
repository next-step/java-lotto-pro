package step3;

import step3.model.LottoPaper;
import step3.model.LottoShop;
import step3.model.Money;
import step3.model.WinningResult;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {

        // 금액 입력
        Money money = new Money(InputView.inputPurchasePrice());

        // 총 구매 티켓 수 알림
        ResultView.announceTotalLottoTicketCount(money.countOfLottoPurchases());

        // 구매 티켓 번호 출력
        LottoPaper lottoPaper = new LottoShop().buyLotto(money);
        ResultView.announceTotalLottoNumbers(lottoPaper);

        // 지난주 당첨 번호 입력
        WinningResult winningResult = new WinningResult(lottoPaper, InputView.inputWinningNumbersLastWeek(), InputView.inputBonusNumber());

        // 결과 출력
        ResultView.resultStart();
        ResultView.WinningResult(winningResult);
    }
}
