package step3.domain;

import java.util.Objects;

public class LottoElement implements Comparable<LottoElement> {

    private final int element;
    private final int LOTTO_MIN = 1;
    private final int LOTTO_MAX = 46;
    private final String CREATE_ELEMENT_EXCEPTION_MSG = "로또 번호는 %s 이상 %s 이하의 숫자여야합니다";

    public LottoElement(String element) {
        this.element = validElement(element);
    }

    private int validElement(String element) {
        int parseElement = parseNumber(element);
        validNumberRange(parseElement);
        return parseElement;
    }

    private void validNumberRange(int parseElement) {
        if (parseElement < LOTTO_MIN || parseElement > LOTTO_MAX) {
            throw new IllegalArgumentException(String.format(CREATE_ELEMENT_EXCEPTION_MSG, LOTTO_MIN, LOTTO_MAX));
        }
    }

    private int parseNumber(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
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
        if (target < source) {
            return 1;
        } else if (target > source) {
            return -1;
        } else {
            return 0;
        }

    }
}
