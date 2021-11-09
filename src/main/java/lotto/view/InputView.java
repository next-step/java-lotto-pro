package lotto.view;

import lotto.domain.Money;
import lotto.domain.Number;
import lotto.domain.StringUtils;
import lotto.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final Scanner scanner = new Scanner(System.in);

    public Money inputPurchaseMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = new Scanner(System.in).nextLine();
            try {
                Money purchaseMoney = new Money(Integer.parseInt(input));
                return purchaseMoney;
            } catch (Exception e) {
                System.out.println("음수가 아닌 숫자만 입력 가능합니다. (입력값: " + input + ")");
                System.out.println();
            }
        }
    }

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
}
