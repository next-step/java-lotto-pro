package lotto.view;

import lotto.domain.*;
import lotto.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final int MINUS_COUNT = 1;
    public static final String EMPTY_MESSAGE = "";
    public static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private final Scanner scanner = new Scanner(System.in);

    public Money getPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
        return new Money(Integer.parseInt(scanner.nextLine()));
    }

    public WinningNumbers getWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String input = scanner.nextLine();
        List<Integer> intNumbers = StringUtils.convertIntegerList(input);
        List<Number> numbers = new ArrayList<>();
        for (int number : intNumbers) {
            numbers.add(new Number(number));
        }
        return new WinningNumbers(numbers);
    }

    public Number getBonusNumber() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        int input = Integer.parseInt(scanner.nextLine());
        return new Number(input);
    }

    public PurchaseCount getManualPurchaseCount() {
        System.out.println(EMPTY_MESSAGE);
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        int input = Integer.parseInt(scanner.nextLine());
        return new PurchaseCount(input);
    }

    public List<List<Integer>> getManualNumbers(PurchaseCount manualPurchaseCount) {
        System.out.println(EMPTY_MESSAGE);
        System.out.println(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);
        List<List<Integer>> manualNumbers = new ArrayList<>();
        while (manualPurchaseCount.isGreaterThanZero()) {
            String input = scanner.nextLine();
            manualNumbers.add(StringUtils.convertIntegerList(input));
            manualPurchaseCount = manualPurchaseCount.minus(MINUS_COUNT);
        }
        return manualNumbers;
    }
}
