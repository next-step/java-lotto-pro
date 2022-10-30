package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    public static int moneyInput() {
        System.out.println("구매 금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> winNumberInput() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String message = scanner.next();
        List<Integer> winNumberList = new ArrayList<>();
        for (String number : message.split(",")) {
            winNumberList.add(Integer.valueOf(number));
        }
        return winNumberList;
    }
}
