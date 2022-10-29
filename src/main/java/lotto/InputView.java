package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    int inputPay() {
        System.out.println("구입금액을 입력해 주세요.");
        return Validate.validatePay(sc.nextLine());
    }

    List<Integer> inputWinningNumberLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        StringTokenizer input = new StringTokenizer(sc.nextLine(), ", ");
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(Integer.parseInt(input.nextToken()));
        }
        return winningNumbers;
    }
}
