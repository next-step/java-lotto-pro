package lotto;

import view.InputView;
import view.ResultView;

public class Lotto {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_NUMBER_OF_PURCHASED_LOTTO = "개를 구매했습니다.";

    public void start() {
        ResultView.print(ASK_PURCHASE_AMOUNT);
        LottoMoney lottoMoney = new LottoMoney(InputView.readLine());
        int count = lottoMoney.calculateLottoCount();
        ResultView.print(count + PRINT_NUMBER_OF_PURCHASED_LOTTO);

        LottoTickets lottoTickets = new LottoTickets(count);
        ResultView.print(lottoTickets.makeMessage());
    }
}
