package lotto.view;

import java.util.Scanner;

import lotto.domain.Money;

public class InputView {
    private static final String INSERT_MONEY = "구입금액을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public Money enterMoney() {
        System.out.println(INSERT_MONEY);
        return new Money(scanner.nextInt());
    }

}
