package step3.domain;

public class Money {
    private static final int PRICE_LOTTO = 1_000;

    private final int element;

    public Money(int element) {
        validate(element);
        this.element = element;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 0 이상의 값을 입력해주세요.");
        }
    }

    public static int investmentAmount(int manualLottoCount, int autoLottoCount) {
        return (manualLottoCount + autoLottoCount) * PRICE_LOTTO;
    }

    public int lottoCount() {
        return element / PRICE_LOTTO;
    }
}
