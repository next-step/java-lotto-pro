package study.lotto.view;

import study.lotto.domain.Order;
import study.lotto.domain.WinningNumbers;

import java.util.Scanner;

public class LottoInput {

    private static final Scanner scanner = new Scanner(System.in);

    public Order inputQuantity() {
        return new Order(scanner.nextLine());
    }

    public WinningNumbers inputWinningNumbers() {
        return new WinningNumbers(scanner.nextLine());
    }
}
