package lotto.view;

import lotto.domain.Money;
import nextstep.utils.Console;

public class InputView {
    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static Money getUserMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return new Money(Integer.parseInt(Console.readLine()));
    }
}
