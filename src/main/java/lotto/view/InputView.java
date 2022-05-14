package lotto.view;

import static lotto.constants.LottoConstants.NUMBERS_DELIMITER;
import static lotto.messages.LottoGameMessages.INPUT_MONEY;
import static lotto.messages.LottoGameMessages.INPUT_WINNING_LOTTO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Money;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public Money inputMoney() {
        System.out.println(INPUT_MONEY);
        String inputMoney = readLine();
        return Money.from(Integer.parseInt(inputMoney));
    }

    public List<Integer> inputWinningLottoNumbers() {
        System.out.println(INPUT_WINNING_LOTTO);
        String inputLottoNumbers = readLine();
        String[] strings = splitLottoNumbers(inputLottoNumbers);
        return Arrays.stream(strings).
                map(String::trim).
                map(Integer::parseInt).
                collect(Collectors.toList());
    }

    private String[] splitLottoNumbers(String inputLottoNumbers) {
        return inputLottoNumbers.split(NUMBERS_DELIMITER);
    }

    private String readLine() {
        return scanner.nextLine();
    }


}
