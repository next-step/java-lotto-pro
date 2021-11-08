package lotto.ui;

import lotto.domain.Lottos;
import lotto.domain.Winnings;

import java.util.Map;

public interface ResultView {

    void printPurchaseAmountMessage();
    void printPurchaseAckMessage(int manualLottosCount, int autoLottosCount);
    void printLottos(Lottos lottos);
    void printLastWinLottoNumbersMessage();
    void printWinStatisticMessage();
    void printCorrespondLottoNumber(Map<Winnings, Integer> statistic);
    void printTotalRevenueMessage(double percentage);
    void printBonusNumberInputMessage();
    void printPurchaseManualLottosCountMessage();
    void printPurchaseManualLottosNumberMessage();

}
