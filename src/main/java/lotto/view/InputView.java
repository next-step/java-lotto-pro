package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.model.Lotto;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNER_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String DELIMITER = ", ";

    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int quantity = scanner.nextInt();
        scanner.nextLine();
        return quantity;
    }

    public static Lotto inputWinnerNumber() {
        System.out.println(INPUT_WINNER_NUMBER_MESSAGE);
        String stringNumbers = scanner.nextLine();
        String[] split = stringNumbers.split(DELIMITER);

        List<Integer> winnerNumbers = new ArrayList<>();
        for (String stringNumber : split) {
            winnerNumbers.add(Integer.parseInt(stringNumber));
        }
        Lotto winnerLotto = new Lotto(winnerNumbers);
        return winnerLotto;
    }

}
