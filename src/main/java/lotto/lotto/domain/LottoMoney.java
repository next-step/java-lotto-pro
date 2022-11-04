package lotto.lotto.domain;

public class LottoMoney {

    private final int number;

    public LottoMoney(int number) {
        this.number = number;
        validateMultiple(number);
    }

    private static void validateMultiple(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("1000의 배수만 입력가능합니다.");
        }
    }

    public long getNumber() {
        return number;
    }

    public int purchaseCount() {
        return number / 1000;
    }
}
