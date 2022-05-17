package lotto.view;

import lotto.constants.DisplayMessage;
import lotto.domain.LottoNumber;
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

    public LottoNumber inputBonusBall() {
        System.out.println(DisplayMessage.INPUT_BONUS_BALL);
        String bonusBall = readLine();
        return LottoNumber.from(StringToIntegerParser.parseInt(bonusBall));
    }

    public int inputManualCount() {
        System.out.printf(DisplayMessage.INPUT_MANUAL_COUNT);
        String manualCount = readLine();
        return StringToIntegerParser.parseInt(manualCount);
    }

    public List<Integer> inputManualNumbers() {
        String inputNumbers = readLine();
        return StringCommaSplitter.splitNumbers(inputNumbers);
    }

    private String readLine() {
        return scanner.nextLine();
    }
}
