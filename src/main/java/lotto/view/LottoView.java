package lotto.view;

import lotto.domain.Rank;


public interface LottoView {
    void showMessageRequestPurchaseMoney();

    void showLottoCount(int manualCount, int autoCount);

    void showLotto(String lottoString);

    void showMessageRequestWinningNumbers();

    void showMessageStatistics();

    void showStatistics(Rank bonus, int count);

    void showYield(double calcYield);

    void showMessageRequestBonusNumber();

    void showRequestManualLottoCount();

    void showRequestManualLottoList();
}
