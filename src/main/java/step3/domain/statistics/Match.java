package step3.domain.statistics;

import java.util.Objects;

public class Match {

    private final int count;
    private final boolean bonus;

    public Match(int count, boolean bonus) {
        this.count = count;
        this.bonus = bonus;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match that = (Match) o;
        return count == that.count && bonus == that.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, bonus);
    }
}
