package lotto.view;

import java.util.Scanner;
import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.result.DefaultLottoResult;

public class LottoConsoleView implements LottoView {

    @Override
    public String readPurchase() {
        System.out.println(PRINT_READ_PURCHASE);
        return new Scanner(System.in).nextLine();
    }

    @Override
    public String readWinningNumber() {
        System.out.println(PRINT_READ_WINNING_NUMBER);
        return new Scanner(System.in).nextLine();
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
}
