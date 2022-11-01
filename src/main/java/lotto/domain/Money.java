package lotto.domain;

import lotto.view.OutputView;

public class Money {
    private static final int FIRST_CHAR_INDEX = 0;
    private static final int SECOND_CHAR_INDEX = 1;
    private static final char NEGATIVE_CHAR = '-';

    private final String money;

    public Money(String inputMoney) {
        this.money = inputMoney;
        validFirstChar();
        validString();
    }

    private void validFirstChar() {
        char firstChar = this.money.charAt(FIRST_CHAR_INDEX);
        if (isValidFirstChar(firstChar)) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_INPUT_ONLY_NUMBER);
        }
    }

    private static boolean isValidFirstChar(char firstChar) {
        return !(firstChar == NEGATIVE_CHAR || Character.isDigit(firstChar));
    }

    private void validString() {
        for (int i = SECOND_CHAR_INDEX; i < this.money.length(); i++) {
            isDigit(this.money, i);
        }
    }

    private static void isDigit(String inputAmount, int i) {
        if (!Character.isDigit(inputAmount.charAt(i))) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_INPUT_ONLY_NUMBER);
        }
    }

    public int parseAmount() {
        try {
            return Integer.parseInt(this.money);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(OutputView.ERROR_MESSAGE_INPUT_AMOUNT_EXCESS);
        }
    }
}
