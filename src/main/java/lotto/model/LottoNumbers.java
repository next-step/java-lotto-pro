package lotto.model;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoNumbers {
    static final int NUMBER_SIZE = 6;
    static final String NUMBER_SIZE_ERR_MSG = "로또 숫자는 " + NUMBER_SIZE + "개로 구성되어야 합니다.";

    private final SortedSet<Number> numbers;

    public LottoNumbers(NumberSupplier numberSupplier) {
        this.numbers = Collections.unmodifiableSortedSet(new TreeSet<>(numberSupplier.getNumbers()));
        validate();
    }

    private void validate() {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERR_MSG);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
