package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputProvider {
    private final static Scanner SCANNER = new Scanner(System.in);
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBERS = "보너스 볼을 입력해 주세요.";
    private static final String ENTER_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ENTER_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    public static Integer purchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return SCANNER.nextInt();
    }

    public static String lottoNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
        SCANNER.nextLine();
        return SCANNER.nextLine();
    }

    public static int bonusNumber() {
        System.out.println(ENTER_BONUS_NUMBERS);
        return SCANNER.nextInt();
    }

    public static int manualLottoCount() {
        System.out.println(ENTER_MANUAL_LOTTO_COUNT);
        return SCANNER.nextInt();
    }

    public static List<String> manualLottoNumbers(int purchaseCount) {
        System.out.println(ENTER_MANUAL_LOTTO_NUMBERS);
        return IntStream.range(0, purchaseCount)
                .mapToObj(it -> SCANNER.nextLine())
                .collect(Collectors.toList());
    }
}
