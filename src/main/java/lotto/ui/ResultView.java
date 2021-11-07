package lotto.ui;

import lotto.domain.Lottos;
import lotto.domain.Winnings;

import java.util.Map;

public interface ResultView {

    void printPurchaseAmountMessage();
    void printPurchaseAckMessage(int count);
    void printLottos(Lottos lottos);
    void printLastWinLottoNumbersMessage();
    void printWinStatisticMessage();
    void printCorrespondLottoNumber(Map<Winnings, Integer> statistic);
    void printTotalRevenueMessage(double percentage);
}
