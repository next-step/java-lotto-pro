package step3.domain;

public class LottoCount {

    public static final int MIN_LOTTO_COUNT = 0;

    private final int element;

    public LottoCount(int element) {
        validate(element);
        this.element = element;
    }

    private void validate(int lottoCount) {
        if (lottoCount < MIN_LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 구매 개수는 0 이상으로 입력해주세요.");
        }
    }

    public int get() {
        return element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoCount that = (LottoCount) o;

        return element == that.element;
    }

    @Override
    public int hashCode() {
        return element;
    }

    @Override
    public String toString() {
        return "LottoCount{" +
                "element=" + element +
                '}';
    }
}
