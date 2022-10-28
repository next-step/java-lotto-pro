package lotto;

import java.util.Objects;

public class Lotto {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final String RANGE_ERROR_MESSAGE = "로또 숫자는 1부터 45까지의 숫자이어야 합니다.";
    private final int number;

    private Lotto(int number) {
        this.number = number;
    }

    public static Lotto valueOf(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new RuntimeException(RANGE_ERROR_MESSAGE);
        }
        return new Lotto(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return number == lotto.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
