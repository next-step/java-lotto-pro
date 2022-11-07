package lotto;

public class LottoPurchaseAmount {

    private final int number;

    public LottoPurchaseAmount(int number) {
        this.number = number;
        validateMultiple(number);
    }

    private static void validateMultiple(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("1000의 배수만 입력가능합니다.");
        }
    }
}
