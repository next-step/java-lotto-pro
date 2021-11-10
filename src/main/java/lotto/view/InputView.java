package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);
    private List<String> manualStrings = new ArrayList<>();

    public String inputMoney() {
        System.out.println(PURCHASE_MESSAGE);
        return scanner.nextLine();
    }

    public String inputWiningLotto() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public String inputBonusBall() {
        System.out.println(BONUS_BALL_MESSAGE);
        return scanner.nextLine();
    }

    public String inputManualCountLotto() {
        System.out.println(MANUAL_LOTTO_COUNT_MESSAGE);
        return scanner.nextLine();
    }

    public List<String> inputManualLotto(int count) {
        System.out.println(MANUAL_LOTTO_MESSAGE);
        manualStrings.clear();
        for (int i = 0; i < count; i++) {
            manualStrings.add(scanner.nextLine());
        }
        return manualStrings;
    }
}
