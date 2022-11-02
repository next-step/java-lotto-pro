package step3.view;

import step3.model.Lotto;
import step3.model.LottoCalculator;
import step3.model.LottoGenerator;

import java.util.Scanner;

import static step3.constant.Message.System.*;
public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    public static String inputString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void inputStringNoReply(String message) {
        System.out.println(message);
    }

    public static String getNextLineString() {
        return scanner.nextLine();
    }

    public static void inputLastWeekLottoNumbers(LottoCalculator calculator) {
        System.out.println(LAST_LOTTO_NUMBERS_INPUT_MESSAGE);
        String[] lastWeekNumbers = new Lotto().validateInputStringLottoNumber(scanner.nextLine());
        calculator.setLastWeekWinner(inputLastWeekBonusNumber(lastWeekNumbers));
    }

    public static Lotto inputLastWeekBonusNumber(String[] lastWeekLottos) {
        System.out.println(LAST_BONUS_NUMBER_INPUT_MESSAGE);
        return new Lotto(lastWeekLottos, scanner.nextLine());
    }
}
