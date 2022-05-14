package lotto.view;

import static lotto.constants.LottoConstants.NUMBERS_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Money;

public class InputView {
    public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";


    private static final Scanner scanner = new Scanner(System.in);

    public static Money inputMoney() {
        System.out.println(INPUT_MONEY);
        String inputMoney = readLine();
        return Money.from(Integer.parseInt(inputMoney));
    }

    public static List<Integer> inputWinningLottoNumbers() {
        System.out.println(INPUT_WINNING_LOTTO);
        String inputLottoNumbers = readLine();
        String[] strings = splitLottoNumbers(inputLottoNumbers);
        return Arrays.stream(strings).
                map(String::trim).
                map(Integer::parseInt).
                collect(Collectors.toList());
    }

    private static String[] splitLottoNumbers(String inputLottoNumbers) {
        return inputLottoNumbers.split(NUMBERS_DELIMITER);
    }

    private static String readLine() {
        return scanner.nextLine();
    }


}
