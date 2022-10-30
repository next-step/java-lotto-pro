package study.lotto.view;

import study.lotto.domain.Order;
import study.lotto.domain.WinningLotto;

import java.util.Scanner;

public class LottoInput {

    private static final Scanner scanner = new Scanner(System.in);

    public Order inputQuantity() {
        return new Order(scanner.nextLine());
    }

    public WinningLotto inputWinningNumbers() {
        return new WinningLotto(scanner.nextLine());
    }

    public void inputBonusBall(WinningLotto winningLotto) {
        winningLotto.addBonusBall(scanner.nextInt());
    }
}
