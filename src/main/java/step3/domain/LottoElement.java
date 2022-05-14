package step3.domain;

import java.util.Objects;

public class LottoElement {

    private final int element;

    protected LottoElement(int element) {
        this.element = element;
    }

    public static LottoElement create(int element) {
        validElement(element);
        return new LottoElement(element);
    }

    private static void validElement(int element) throws IllegalArgumentException {
        if (element <= 0) {
            throw new IllegalArgumentException("로또 번호는 0 이상의 숫자여야합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoElement that = (LottoElement) o;
        return element == that.element;
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }
}
