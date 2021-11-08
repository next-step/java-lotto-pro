package lotto.view;

import lotto.domain.LottoBall;
import lotto.domain.Money;
import lotto.exception.ErrorCode;
import lotto.exception.ExecutePrivateConstructorException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_TRY_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new ExecutePrivateConstructorException(ErrorCode.INPUT_VIEW.getMsg());
    }

    public static Money inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int money = scanner.nextInt();
        return new Money(money);
    }

    public static List<LottoBall> inputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS_MESSAGE);
        String winNumberString = scanner.next();
        return Arrays.stream(winNumberString.split(","))
                .map(number -> new LottoBall(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }

    public static LottoBall inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        int number = scanner.nextInt();
        return new LottoBall(number);
    }

    public static int inputManualTryCount() {
        System.out.println(INPUT_MANUAL_TRY_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
