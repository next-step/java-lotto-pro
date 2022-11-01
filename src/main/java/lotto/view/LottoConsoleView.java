package lotto.view;

import java.util.Scanner;
import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.result.DefaultLottoResult;

public class LottoConsoleView implements LottoView {

    private static final String PRINT_READ_PURCHASE = "구입금액을 입력해 주세요.";
    private static final String PRINT_READ_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PRINT_READ_BONUS = "보너스 볼을 입력해 주세요.";
    private static final String RESULT_HEADER = "\n당첨 통계\n--------";

    @Override
    public String readPurchase() {
        return readLine(PRINT_READ_PURCHASE);
    }

    @Override
    public String readWinningNumber() {
        return readLine(PRINT_READ_WINNING_NUMBER);
    }

    @Override
    public String readBonus() {
        return readLine(PRINT_READ_BONUS);
    }

    @Override
    public void printLottoNumbers(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    @Override
    public void printResult(DefaultLottoResult lottoResult) {
        System.out.println(RESULT_HEADER);
        System.out.println(lottoResult);
    }

    @Override
    public void printProfitMargin(String profitMargin) {
        System.out.println(profitMargin);
    }

    @Override
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private String readLine(String printMessage) {
        System.out.println(printMessage);
        return new Scanner(System.in).nextLine();
    }
}
