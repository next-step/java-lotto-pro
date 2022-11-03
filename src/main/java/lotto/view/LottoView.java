package lotto.view;

import java.util.List;
import lotto.domain.result.DefaultLottoResult;

public interface LottoView {

    String readPurchase();

    String readWinningNumber();

    String readBonus();

    String readManualLottoCount();

    List<String> readManualLottoNumber(int manualLottoCount);

    void printLottoNumbers(String lottoNumbersResult);

    void printResult(DefaultLottoResult lottoResult);

    void printProfitMargin(String profitMargin);

    void printErrorMessage(String errorMessage);
}
