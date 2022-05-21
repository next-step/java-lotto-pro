package lotto.ui;

import java.util.List;

public interface InputView {
    int takeBudget();

    List<Integer> takeWinMainNumbers();

    int takeBonusNumbers();

    int takeManualBuyCount();

    List<Integer> takeManualLottoNumbers();

    void printManualLottoNumbersHeader();
}
