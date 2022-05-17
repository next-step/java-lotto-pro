package camp.nextstep.edu.step3;

import java.util.Objects;

public class Count {
    private static final int MIN = 0;
    private final int count;

    public Count(final int count) {
        if (MIN > count) {
            throw  new IllegalArgumentException("ManualCount is not negative");
        }
        this.count = count;
    }

    public Count decrease() {
        return new Count(count-1);
    }

    public boolean isDecrease() {
        return this.count > MIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count that = (Count) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
