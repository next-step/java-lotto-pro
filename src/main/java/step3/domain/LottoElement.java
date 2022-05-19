package step3.domain;

import java.util.Objects;

public class LottoElement implements Comparable<LottoElement>, Cloneable {

    private final int element;
    private final int LOTTO_MIN = 1;
    private final int LOTTO_MAX = 45;
    private final String CREATE_ELEMENT_EXCEPTION_MSG = "로또 번호는 %s 이상 %s 이하의 숫자여야합니다";
    private final String COPY_ELEMENT_EXCEPTION_MSG = "LottoElement 복사중 에러가 발생하였습니다";


    public LottoElement(int element) {
        this.element = validElement(element);
    }

    private int validElement(int element) {
        validNumberRange(element);
        return element;
    }


    private void validNumberRange(int parseElement) {
        if (parseElement < LOTTO_MIN || parseElement > LOTTO_MAX) {
            throw new IllegalArgumentException(String.format(CREATE_ELEMENT_EXCEPTION_MSG, LOTTO_MIN, LOTTO_MAX));
        }
    }

    public int getElement() {
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
        LottoElement that = (LottoElement) o;
        return Objects.equals(element, that.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }

    @Override
    public int compareTo(LottoElement o) {
        int source = element;
        int target = o.getElement();
        return Integer.compare(source, target);
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }

    @Override
    protected LottoElement clone() {
        try {
            return (LottoElement) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException(COPY_ELEMENT_EXCEPTION_MSG);
        }
    }
}
