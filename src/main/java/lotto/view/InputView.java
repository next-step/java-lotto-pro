package lotto.view;

import lotto.domain.Money;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Money getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Money.from(scanner.nextInt());
    }
}
