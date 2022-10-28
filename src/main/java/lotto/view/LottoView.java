package lotto.view;

import lotto.domain.WinningBonus;

import java.util.List;

public interface LottoView {
    void showMessageRequestPurchaseMoney();
    void showLottoCount(int size);

    void showLotto(List<String> printAll);

    void showMessageRequestWinningNumbers();

    void showMessageStatistics();

    void showStatistics(WinningBonus bonus, int count);

    void showYield(double calcYield);
}
