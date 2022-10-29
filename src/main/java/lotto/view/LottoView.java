package lotto.view;

import lotto.domain.WinningBonus;


public interface LottoView {
    void showMessageRequestPurchaseMoney();
    void showLottoCount(int size);

    void showLotto(String lottoString);

    void showMessageRequestWinningNumbers();

    void showMessageStatistics();

    void showStatistics(WinningBonus bonus, int count);

    void showYield(double calcYield);
}
