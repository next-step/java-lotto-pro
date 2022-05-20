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

    public static int investmentAmount(LottoCount manualLottoCount, LottoCount autoLottoCount) {
        return (manualLottoCount.get() + autoLottoCount.get()) * PRICE_LOTTO;
    }

    public int lottoCount() {
        return element / PRICE_LOTTO;
    }

    public LottoCount autoLottoCount(LottoCount manualLottoCount) {
        return new LottoCount(Math.max(lottoCount() - manualLottoCount.get(), 0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money = (Money) o;

        return element == money.element;
    }

    @Override
    public int hashCode() {
        return element;
    }

    @Override
    public String toString() {
        return "Money{" +
                "element=" + element +
                '}';
    }
}
