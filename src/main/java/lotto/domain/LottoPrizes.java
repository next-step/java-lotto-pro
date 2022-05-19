package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoPrizes {
    private final List<LottoPrize> lottoPrizes;

    public LottoPrizes(List<LottoPrize> lottoPrizes) {
        this.lottoPrizes = lottoPrizes;
    }

    public List<LottoPrize> getLottoPrizes() {
        return this.lottoPrizes;
    }

    public int size() {
        return this.lottoPrizes.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrizes that = (LottoPrizes) o;
        return Objects.equals(lottoPrizes, that.lottoPrizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoPrizes);
    }

    @Override
    public String toString() {
        return "LottoPrizes{" +
                "lottoPrizes=" + lottoPrizes +
                '}';
    }
}
