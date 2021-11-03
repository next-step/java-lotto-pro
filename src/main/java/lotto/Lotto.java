package lotto;

import view.InputView;
import view.OutputMessage;
import view.ResultView;

public class Lotto {
    public void start() {
        ResultView.print(OutputMessage.ASK_PURCHASE_AMOUNT::getMessage);
        LottoMoney lottoMoney = new LottoMoney(InputView.readLine());
        int count = lottoMoney.calculateLottoCount();
        ResultView.print(() -> count + OutputMessage.PRINT_NUMBER_OF_PURCHASED_LOTTO.getMessage());

        LottoTickets lottoTickets = new LottoTickets(count);
        ResultView.print(lottoTickets);
    }
}
