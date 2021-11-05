package lotto;

import java.util.Objects;

import view.Printable;

public class LottoCount implements Printable {
    private final int count;

    public LottoCount(int count) {
        this.count = count;
    }

    public boolean isBiggerThan(int count) {
        return count < this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoCount)) {
            return false;
        }
        LottoCount that = (LottoCount)o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String makePrintableMessage() {
        return String.valueOf(count);
    }
}
