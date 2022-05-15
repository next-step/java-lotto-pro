package lotto.view;

import lotto.WinningResult;
import lotto.lotto.Lotto;
import lotto.money.Money;

import java.util.List;

public interface ResultView {

    static ResultView console() {
        return new ConsoleResultView();
    }

    void printLottoes(List<Lotto> lottoes, int sizeOfManualLottoes);

    void printResult(WinningResult winningResult, Money money);
}
