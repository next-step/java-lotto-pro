package step3.view;

import java.util.Scanner;
import step3.model.value.OperationMsg;

public class InputView {

    public static String requestInputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(OperationMsg.REQUEST_INPUT_MONEY);
        return scanner.next();
    }

    public static String requestInputLotto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(OperationMsg.REQUEST_INPUT_LOTTO);
        return scanner.next();
    }


}
