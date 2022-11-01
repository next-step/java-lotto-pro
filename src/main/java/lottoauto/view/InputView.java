package lottoauto.view;

import static lottoauto.io.InputUtils.*;
import static lottoauto.io.PrintUtils.println;

public abstract class InputView {

    public static String payLotto() {
        println("구입금액을 입력하세요.");
        return readConsole();
    }
}
