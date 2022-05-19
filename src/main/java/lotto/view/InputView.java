package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static lotto.view.message.InputMessage.*;

public class InputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final String IO_EXCEPTION_OCCURRED = "I/O 예외가 발생했습니다.";

    public static String inputPurchaseAmount() {
        return input(ENTER_PURCHASE_AMOUNT.message());
    }

    public static String inputWinningNumbers() {
        return input(ENTER_WINNING_NUMBER.message());
    }

    public static String inputBonusBall() {
        return input(ENTER_BONUS_BALL.message());
    }

    public static String inputManualLottoCount() {
        return input(ENTER_MANUAL_LOTTO_COUNT.message());
    }

    private static String input(String message) {
        System.out.println(message);
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(IO_EXCEPTION_OCCURRED);
        }
    }

}
