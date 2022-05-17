package lotto.domain;

import lotto.view.OutputView;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final int LOTTO_NUMBERS_COUNT = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private int number;

    public LottoNumber(int number) {
        isValidRange(number);
        this.number = number;
    }

    public LottoNumber(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);
            isValidRange(number);
            this.number = number;
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.stream()
                .limit(LOTTO_NUMBERS_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }

    private void isValidRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
