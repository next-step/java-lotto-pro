package lotto;

import java.util.Objects;

public class LottoPrize {
    private final long prize;

    public LottoPrize(long prize) {
        this.prize = prize;
    }

    public LottoPrize calculateMultiple(int multiple) {
        return new LottoPrize(prize * multiple);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoPrize)) {
            return false;
        }
        LottoPrize that = (LottoPrize)o;
        return prize == that.prize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
