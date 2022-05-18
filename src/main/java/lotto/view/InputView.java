package lotto.view;

import java.util.List;
import java.util.Scanner;
import utils.StringUtils;

public class InputView {
    private static final String NUMBER_SEPARATOR = ",";
    private static final String INPUT_BUY_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_RETRY_BUY_PRICE = "로또의 구매금액이 모잘릅니다. 재 입력 해주세요.";
    private static final String INPUT_WINNER_NUMBER = "지난 주 당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해주세요.";
    private static final String INPUT_MANUAL_LOTTO_QTY = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ONLY_NUMBER = "숫자만 입력이 가능합니다.";


    public static int userPriceInput() {
        return numberInput(INPUT_BUY_PRICE);
    }

    public static int retryPriceInput() {
        return numberInput(INPUT_RETRY_BUY_PRICE);
    }

    public static int bonusNumberInput() {
        return numberInput(INPUT_BONUS_NUMBER);
    }

    public static int manualLottoQtyInput() {
        return numberInput(INPUT_MANUAL_LOTTO_QTY);
    }

    public static List<Integer> manualNumberInput() {
        return StringUtils.splitTextTrimToInt(new Scanner(System.in).nextLine(), NUMBER_SEPARATOR);
    }

    public static List<Integer> winnerNumberInput() {
        System.out.println(INPUT_WINNER_NUMBER);
        return StringUtils.splitTextTrimToInt(new Scanner(System.in).nextLine(), NUMBER_SEPARATOR);
    }

    private static int numberInput(String message) {
        try {
            System.out.println(message);
            return new Scanner(System.in).nextInt();
        } catch (RuntimeException e) {
            System.out.println(ONLY_NUMBER);
            return numberInput(message);
        }
    }


}
