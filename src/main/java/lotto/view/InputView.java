package lotto.view;

import calculator.utils.Splitter;
import lotto.domain.LottoNumber;
import lotto.message.InputMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(InputMessage.INPUT_MONEY);
        return scanner.nextInt();
    }

    public static List<LottoNumber> inputWinningNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS);
        String[] stringNumbers = Splitter.splitString(scanner.next());

        List<LottoNumber> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            numbers.add(new LottoNumber(stringNumber));
        }
        return numbers;
    }
}
