package camp.nextstep.edu.step3;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int number;
    
    public LottoNumber(final int number) {
        validation(number);
        this.number = number;
    }

    private void validation(final int number) {
        if (MIN > number || number > MAX) {
            throw new IllegalArgumentException(String.format("invalid input : %d", number));
        }
    }

    @Override
    public int compareTo(final LottoNumber target) {
        return target.compareBy(this.number);
    }

    private int compareBy(final int source) {
        return source - this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
