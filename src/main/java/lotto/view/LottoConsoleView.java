package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.result.DefaultLottoResult;

public class LottoConsoleView implements LottoView {

    private static final String PRINT_READ_PURCHASE = "구입금액을 입력해 주세요.";
    private static final String PRINT_READ_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PRINT_READ_BONUS = "보너스 볼을 입력해 주세요.";
    private static final String RESULT_HEADER = "\n당첨 통계\n--------";
    private static final String PRINT_READ_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String PRINT_READ_MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

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
    public String readManualLottoCount() {
        return readLine(PRINT_READ_MANUAL_LOTTO_COUNT);
    }

    @Override
    public List<String> readManualLottoNumber(int manualLottoCount) {
        System.out.println(PRINT_READ_MANUAL_NUMBER_MESSAGE);
        Scanner sc = new Scanner(System.in);
        List<String> manualLottoNumber = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoNumber.add(sc.nextLine());
        }
        return manualLottoNumber;
    }

    @Override
    public void printLottoNumbers(String lottoNumbersResult) {
        System.out.println(lottoNumbersResult);
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
