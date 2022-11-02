package lotto.view;

import static lotto.io.InputUtils.*;
import static lotto.io.PrintUtils.println;

public abstract class InputView {

    public static String payLotto() {
        println("구입금액을 입력하세요.");
        return readConsole();
    }
}
