package lotto.view;

import java.util.List;
import java.util.Scanner;
import utils.StringUtils;

public class InputView {
    private static final String NUMBER_SEPARATOR = ",";
    public static int userPriceInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static List<Integer> winnerNumberInput() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return StringUtils.splitTextTrimToInt(new Scanner(System.in).nextLine(), NUMBER_SEPARATOR);
    }
}
