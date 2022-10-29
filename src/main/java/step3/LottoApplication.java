package step3;

import step3.model.LottoCustomGenerator;
import step3.model.LottoGenerator;
import step3.model.LottoPaper;
import step3.model.LottoShop;
import step3.model.Money;
import step3.model.WinningResult;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {

        // 금액 입력
        Money money = new Money(InputView.inputPurchasePrice());

        int countOfCustomLotto = InputView.inputCountOfCustomLotto(money);

        InputView.inputCustomLottoNumbers();
        List<LottoGenerator> customLottoGenerators = new ArrayList<>();
        for (int i = 0; i < countOfCustomLotto; i++) {
            customLottoGenerators.add(new LottoCustomGenerator(InputView.inputCustomLotto()));
        }

        // 총 구매 티켓 수 알림
        ResultView.announceTotalLottoTicketCount(countOfCustomLotto, money.countOfLottoPurchases());

        // 구매 티켓 번호 출력
        LottoPaper lottoPaper = new LottoShop().buyLotto(money, customLottoGenerators);
        ResultView.announceTotalLottoNumbers(lottoPaper);

        // 지난주 당첨 번호 입력
        WinningResult winningResult = new WinningResult(lottoPaper, InputView.inputWinningNumbersLastWeek(), InputView.inputBonusNumber());

        // 결과 출력
        ResultView.resultStart();
        ResultView.WinningResult(winningResult);
    }
}
