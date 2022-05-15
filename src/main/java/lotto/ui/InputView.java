package lotto.ui;

import lotto.utils.StringUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String WINNING_NUMBERS_DELIMITER = ", ";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Integer inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> inputWinningNumbers() {
        return StringUtils.convertToList(scanner.nextLine(), WINNING_NUMBERS_DELIMITER);
    }
}
