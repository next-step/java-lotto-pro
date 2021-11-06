package lotto.view;

import lotto.domain.Money;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final Scanner scanner = new Scanner(System.in);

    public Money inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int money = scanner.nextInt();
        return new Money(money);
    }
}
