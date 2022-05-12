package lotto.model;

import java.util.Objects;

public class Rank {
    Long rank;

    public Rank(Long rank) {
        this.rank = rank;
    }

    public Long getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rank that = (Rank) o;
        return getRank() == that.getRank();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRank());
    }
}
