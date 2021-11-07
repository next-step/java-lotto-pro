package lotto.view;

import java.util.List;
import java.util.Scanner;

import lotto.domain.Money;
import lotto.utils.ConsoleUtils;
import lotto.utils.ValidationUtils;

public class InputView {
    private static final String INSERT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INSERT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ERROR_ONLY_NUMBER = "구매금액은 숫자만 입력 가능합니다.";

    public Money enterMoney() {
        System.out.println(INSERT_MONEY);
        String number = ConsoleUtils.consoleString();
        if (!ValidationUtils.isNumber(number)) {
            System.out.println(ERROR_ONLY_NUMBER);
            return enterMoney();
        }
        return new Money(Integer.parseInt(number));
    }

    public List<Integer> enterWinningNumbers() {
        System.out.println(INSERT_WINNING_NUMBER);
        return ConsoleUtils.consoleIntegerList();
    }

}
