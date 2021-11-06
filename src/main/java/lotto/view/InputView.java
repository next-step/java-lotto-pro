package lotto.view;

import java.util.Scanner;

import lotto.domain.Lotto;
import lotto.domain.Money;

public class InputView {
    private static final String INSERT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INSERT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public Money enterMoney() {
        System.out.println(INSERT_MONEY);
        return new Money(Integer.parseInt(scanner.nextLine().replaceAll(" ", "")));
    }

    public Lotto enterWinningLotto() {
        System.out.println(INSERT_WINNING_NUMBER);
        return new Lotto(scanner.nextLine().replaceAll(" ", ""));
    }

}
