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

    public static int userPriceInput() {
        System.out.println(INPUT_BUY_PRICE);
        return new Scanner(System.in).nextInt();
    }

    public static int retryPriceInput() {
        System.out.println(INPUT_RETRY_BUY_PRICE);
        return new Scanner(System.in).nextInt();
    }

    public static int bonusNumberInput() {
        System.out.println(INPUT_BONUS_NUMBER);
        return new Scanner(System.in).nextInt();
    }

    public static List<Integer> winnerNumberInput() {
        System.out.println(INPUT_WINNER_NUMBER);
        return StringUtils.splitTextTrimToInt(new Scanner(System.in).nextLine(), NUMBER_SEPARATOR);
    }
}
