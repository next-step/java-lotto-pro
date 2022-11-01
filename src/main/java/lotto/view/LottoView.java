package lotto.view;

import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.result.DefaultLottoResult;

public interface LottoView {

    String readPurchase();

    String readWinningNumber();

    String readBonus();

    void printLottoNumbers(LottoNumbers lottoNumbers);

    void printResult(DefaultLottoResult lottoResult);

    void printProfitMargin(String profitMargin);

    void printErrorMessage(String errorMessage);
}
