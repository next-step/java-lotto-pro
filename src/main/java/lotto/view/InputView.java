package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static stringAddCalculator.utils.Parse.INPUT_ERROR;

public class InputView {
    private static final String START_LOTTO = "구입금액을 입력해주세요.";
    private static final String MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getAmountPrint() {
        System.out.println(START_LOTTO);
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR);
        } finally {
            SCANNER.nextLine();
        }
    }

    public static int getManualCountPrint() {
        System.out.println(MANUAL_LOTTO);
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR);
        } finally {
            SCANNER.nextLine();
        }
    }

    public static List<String> getManualLottoNumbers(int manualCount) {
        System.out.println(MANUAL_LOTTO_NUMBERS);
        List<String> inputManualLottoNumbers = new ArrayList<>();
        int count = 0;
        while (count < manualCount) {
            inputManualLottoNumbers.add(SCANNER.nextLine());
            count++;
        }
        return inputManualLottoNumbers;
    }

    public static int getBonusNumberPrint() {
        System.out.println(BONUS_NUMBER);
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR);
        } finally {
            SCANNER.nextLine();
        }
    }

    public static String getWinningLottoPrint() {
        System.out.println(WINNING_LOTTO);
        String input = SCANNER.nextLine();
        return input;
    }
}
