package lotto.view;

import java.util.List;
import java.util.Scanner;

import lotto.domain.Money;
import lotto.utils.ConsoleUtils;

public class InputView {
    private static final String INSERT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INSERT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    public Money enterMoney() {
        System.out.println(INSERT_MONEY);
        return new Money(ConsoleUtils.consoleInt());
    }

    public List<Integer> enterWinningNumbers() {
        System.out.println(INSERT_WINNING_NUMBER);
        return ConsoleUtils.consoleIntegerList();
    }

}
