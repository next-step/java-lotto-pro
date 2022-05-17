package lotto.ui;

import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
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

    public Integer inputManualCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<List<Integer>> inputManualLottoNumbers(Integer manualCount) {
        if (manualCount == 0) {
            return Collections.emptyList();
        }
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            result.add(StringUtils.convertToList(scanner.nextLine(), WINNING_NUMBERS_DELIMITER));
        }
        return result;
    }


    public List<Integer> inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return StringUtils.convertToList(scanner.nextLine(), WINNING_NUMBERS_DELIMITER);
    }

    public Integer inputWinningBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
