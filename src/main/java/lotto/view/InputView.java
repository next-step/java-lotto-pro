package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String PURCHASE_PRICE_MESSAGE = "\n구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS = "\n수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getPurchaseMoney() {
        OutputView.printMessage(PURCHASE_PRICE_MESSAGE);
        return scanner.nextLine().trim();
    }

    public static String getWinningNumber() {
        OutputView.printMessage(WINNING_NUMBER_MESSAGE);
        return scanner.nextLine().trim();
    }

    public static String getBonusNumber() {
        OutputView.printMessage(BONUS_NUMBER_MESSAGE);
        return scanner.nextLine().trim();
    }

    public static String getManualLottoCount() {
        OutputView.printMessage(MANUAL_LOTTO_COUNT);
        return scanner.nextLine().trim();
    }

    public static List<String> getManualLottoNumbers(int manualTicketAmount) {
        if (manualTicketAmount == 0) {
            return Collections.emptyList();
        }

        OutputView.printMessage(MANUAL_LOTTO_NUMBERS);
        return IntStream.range(0, manualTicketAmount)
                .mapToObj(i -> scanner.nextLine().trim())
                .collect(Collectors.toList());
    }

}
