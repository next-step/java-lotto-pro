package lotto.model;

import java.util.Objects;

public class LottoPaper {

    private final int totalCount;
    private final int selfCount;

    public LottoPaper(int totalCount, int selfCount) {
        this.totalCount = totalCount;
        this.selfCount = selfCount;
    }

    public int getSelfCount() {
        return selfCount;
    }

    public int randomCount() {
        return totalCount - selfCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPaper that = (LottoPaper) o;
        return selfCount == that.selfCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(selfCount);
    }

}
