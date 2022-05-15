package lotto.ui;

import lotto.utils.StringUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String WINNING_NUMBERS_DELIMITER = ",";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Integer inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return StringUtils.convertToList(scanner.nextLine(), WINNING_NUMBERS_DELIMITER);
    }

    public Integer inputWinningBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
