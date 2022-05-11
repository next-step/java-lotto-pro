package lotto.view;

import static lotto.constants.LottoErrorMessage.INVALID_INPUT_MONEY;
import static lotto.constants.LottoGuideMessage.INPUT_MONEY;

import calculator.utils.StringUtils;
import java.util.Scanner;
import lotto.domain.Money;
import lotto.utils.LottoNumberStringToIntegerParser;

public class LottoInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_NUMBER_0_TO_9_REG_EXP = "^[0-9]+$";

    public Money inputMoney(){
        System.out.println(INPUT_MONEY);
        String inputMoney = readLine();

        if (isValidMoney(inputMoney)) {
            return convertToMoney(inputMoney);
        }

        System.out.printf((INVALID_INPUT_MONEY) + "%n", inputMoney);
        return inputMoney();
    }

    private Money convertToMoney(String money) {
        int parseMoney = LottoNumberStringToIntegerParser.parse(money);
        return Money.from(parseMoney);
    }

    private boolean isValidMoney(String money) {
        if (StringUtils.isEmpty(money)) {
            return false;
        }

        return money.matches(INPUT_NUMBER_0_TO_9_REG_EXP);
    }

    private String readLine() {
        return scanner.nextLine();
    }

}
