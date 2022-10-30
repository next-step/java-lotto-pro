package lotto;

import static lotto.Constant.INPUT_PAY_MONEY;
import static lotto.Constant.INPUT_WINNING_NUMBER_LAST_WEEK;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    int inputPay() {
        System.out.println(INPUT_PAY_MONEY);
        return Validate.validatePay(sc.nextLine());
    }

    List<Integer> inputWinningNumberLastWeek() {
        System.out.println("\n" + INPUT_WINNING_NUMBER_LAST_WEEK);
        StringTokenizer input = new StringTokenizer(sc.nextLine(), ", ");
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(Integer.parseInt(input.nextToken()));
        }
        return winningNumbers;
    }
}
