package step3.view;

import java.util.Scanner;
import step3.model.value.OperationMsg;

public class InputView {

    // 인스턴스화 방지
    private InputView() {
        throw new AssertionError();
    }
    private static Scanner scanner = new Scanner(System.in);

    public static String requestInputMoney() {
        System.out.println(OperationMsg.REQUEST_INPUT_MONEY);
        return scanner.nextLine();
    }

    public static String requestInputLotto() {
        System.out.println(OperationMsg.REQUEST_INPUT_LOTTO);
        return scanner.nextLine();
    }


}
