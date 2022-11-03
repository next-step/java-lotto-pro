package step3.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import step3.model.value.OperationMsg;

public class InputView {

    // 인스턴스화 방지
    private InputView() {
        throw new AssertionError();
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static String requestInputMoney() {
        System.out.println(OperationMsg.REQUEST_INPUT_MONEY);
        return scanner.nextLine();
    }

    public static String requestInputLotto() {
        System.out.println(OperationMsg.REQUEST_INPUT_LOTTO);
        return scanner.nextLine();
    }
    public static String requestInputManualLotto() {
        return scanner.nextLine();
    }


    public static int requestInputBonus() {
        System.out.println(OperationMsg.REQUEST_INPUT_BONUS);
        int input =  scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static int requestManualTicketCount() {
        System.out.println(OperationMsg.REQUEST_MANUAL_TICKET_COUNT);
        int input =  scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static List<String> requestInputBonusLotto(int manualTicketCount) {
        System.out.println(OperationMsg.REQUEST_MANUAL_TICKET_NUMBER);
        List<String> manualInputs = new ArrayList<>();
        for(int i =0; i<manualTicketCount;i++){
            manualInputs.add(scanner.nextLine());
        }
        return manualInputs;
    }
}
