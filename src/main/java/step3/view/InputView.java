package step3.view;

import static step3.io.InputUtils.*;
import static step3.io.PrintUtils.println;

public abstract class InputView {

    public static String payLotto() {
        println("구입금액을 입력하세요.");
        return readConsole();
    }
}
