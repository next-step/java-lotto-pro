package lotto;

public class LottoPurchaseAmount {

    private final int number;

    public LottoPurchaseAmount(String stringNumber) {
        int number = convertNumber(stringNumber);
        this.number = number;
        validateMultiple(number);
    }

    private static void validateMultiple(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("1000의 배수만 입력가능합니다.");
        }
    }

    private int convertNumber(String stringNumber) {
        int number = 0;
        try {
            number = Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
        return number;
    }
}
