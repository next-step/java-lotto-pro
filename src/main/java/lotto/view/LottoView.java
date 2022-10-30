package lotto.view;

import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.result.DefaultLottoResult;

public interface LottoView {

    String PRINT_READ_PURCHASE = "구입금액을 입력해 주세요.";
    String PRINT_READ_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    String RESULT_HEADER = "\n당첨 통계\n--------";

    String readPurchase();

    String readWinningNumber();

    void printLottoNumbers(LottoNumbers lottoNumbers);

    void printResult(DefaultLottoResult lottoResult);

    void printProfitMargin(String profitMargin);

    void printErrorMessage(String errorMessage);
}
