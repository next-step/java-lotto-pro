package lotto.view;

import static lotto.io.InputUtils.*;
import static lotto.io.PrintUtils.println;

public abstract class InputView {

    public static String payLotto() {
        println("구입금액을 입력하세요.");
        return readConsole();
    }

    public static String buyManualLotto(){
        println("수동으로 구매할 로또 수를 입력해 주세요.");
        return readConsole();
    }

    public static String inputBonusNumber(){
        println("보너스 볼을 입력해 주세요.");
        return readConsole();
    }
}
