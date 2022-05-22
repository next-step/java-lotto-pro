package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String ASK_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_PASSIVE_NUMBER_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ASK_PASSIVE_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String BLANK = " ";
    private static final String DELIMITER = ",";

    private static Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println(ASK_PRICE_MESSAGE);
        int price = scanner.nextInt();
        scanner.nextLine();
        return price;
    }

    public static int inputPassiveNumberCount(int maxQuantity) {
        System.out.println(ASK_PASSIVE_NUMBER_COUNT_MESSAGE);
        int passiveCount = scanner.nextInt();
        if (passiveCount > maxQuantity) {
            throw new IllegalArgumentException("수동으로 구매할 로또의 수가 최대 발급 수를 초과했습니다.");
        }
        scanner.nextLine();
        return passiveCount;
    }

    public static List<String[]> inputPassiveNumbers(int passiveCount) {
        System.out.println(ASK_PASSIVE_NUMBERS_MESSAGE);
        List<String[]> numbersArray = new ArrayList<>();
        for(int i = 0; i < passiveCount; i++) {
            String[] numbers = scanner.nextLine().replace(BLANK, "").split(DELIMITER);
            numbersArray.add(numbers);
        }
        return numbersArray;
    }

    public static String[] inputWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS_MESSAGE);
        return scanner.nextLine().replace(BLANK, "").split(DELIMITER);
    }

    public static int inputBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE);
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }

}
