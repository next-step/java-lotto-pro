package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.Lottos;

public class InputView {
    static final String PRINT_INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    static final String PRINT_INPUT_WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    static final String PRINT_INPUT_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    static final String PRINT_INPUT_MANUAL_LOTTO_NO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    static final String PRINT_INPUT_BONUS_BALL_LOTTO_MESSAGE = "보너스 볼 입력해 주세요.";
    static final String EXCEPTION_MESSAGE_MANUAL_COUNT = "수동 구매 매수가 총 가능 구매 매수보다 큽니다.";
    static final String EXCEPTION_MESSAGE_NOT_NUMBERTYPE = "%s은 숫자입니다.";
    static final String EXCEPTION_MESSAGE_NOT_NATURAL_NUMBER = "%s은 음수일 수 없습니다.";
    static final String WINNING_LOTTO_DELIMITER = ",";
    static final Scanner scanner = new Scanner(System.in);

    public static int getMoneyInput() {
        System.out.println(PRINT_INPUT_MONEY_MESSAGE);
        String inputMoney = scanner.nextLine();

        return validateMoneyInput(inputMoney);
    }

    public static int validateMoneyInput(String inputMoney) {
        return validateNumberType(inputMoney, "금액");
    }

    public static int getManualCount(int totalMoney) {
        System.out.println(PRINT_INPUT_MANUAL_COUNT_MESSAGE);
        String inputManualCount = scanner.nextLine();

        return validateManualCount(inputManualCount, totalMoney);
    }

    private static int validateManualCount(String inputManualCount, int totalMoney) {
        int manualCount = validateNumberType(inputManualCount, "수량");
        if (manualCount > totalMoney / Lotto.LOTTO_PRICE) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MANUAL_COUNT);
        }
        return manualCount;
    }

    public static Lottos getManualLottosInput(int count) {
        System.out.println(PRINT_INPUT_MANUAL_LOTTO_NO_MESSAGE);
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualLottos.add(generateLottoBySplitSpring());
        }
        return new Lottos(manualLottos);
    }

    private static int validateNumberType(String input, String typeName) {
        int exchangedNumber;
        try {
            exchangedNumber = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            String exceptionMessage = String.format(EXCEPTION_MESSAGE_NOT_NUMBERTYPE, typeName);
            throw new IllegalArgumentException(exceptionMessage);
        }
        if (exchangedNumber < 0) {
            String exceptionMessage = String.format(EXCEPTION_MESSAGE_NOT_NATURAL_NUMBER, typeName);
            throw new IllegalArgumentException(exceptionMessage);
        }
        return exchangedNumber;
    }

    public static Lotto getWinningLottoInput() {
        System.out.println(PRINT_INPUT_WINNING_LOTTO_MESSAGE);

        return generateLottoBySplitSpring();
    }

    private static Lotto generateLottoBySplitSpring() {
        String winningLottoInput = scanner.nextLine();

        String[] splitWinningLotto = winningLottoInput.split(WINNING_LOTTO_DELIMITER);
        return new Lotto(splitWinningLotto);
    }

    public static LottoNo getBonusNumberInput(Lotto winningLotto) {
        System.out.println(PRINT_INPUT_BONUS_BALL_LOTTO_MESSAGE);
        String bonusBallInput = scanner.nextLine();

        LottoNo bonusBall = LottoNo.createLotto(bonusBallInput);

        return bonusBall.validateBonus(winningLotto);
    }
}