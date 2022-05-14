package lotto.view;

import lotto.constants.DisplayMessage;
import lotto.domain.Money;
import lotto.util.StringCommaSplitter;
import lotto.util.StringToIntegerParser;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public Money inputPurchaseMoney() {
        System.out.println(DisplayMessage.INPUT_PURCHASE_MONEY);
        String inputPurchaseMoney = readLine();
        return Money.from(StringToIntegerParser.parseInt(inputPurchaseMoney));
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(DisplayMessage.INPUT_WINNING_NUMBERS);
        String inputNumbers = readLine();
        return StringCommaSplitter.splitNumbers(inputNumbers);
    }

    private String readLine() {
        return scanner.nextLine();
    }
}
