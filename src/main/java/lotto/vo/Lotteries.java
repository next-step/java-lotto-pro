package lotto.vo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Lotteries {
    private final static String LOTTERIES_WERE_NOT_GENERATED = "로또가 생성되지 않았습니다.";

    private final List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteries) {
        if (isNull(lotteries)) {
            throw new NullPointerException(LOTTERIES_WERE_NOT_GENERATED);
        }
        this.lotteries = new LinkedList<>(lotteries);
    }

    private boolean isNull(List<Lottery> lotteries) {
        return lotteries == null;
    }

    public List<Lottery> list() {
        return Collections.unmodifiableList(lotteries);
    }

    public int size() {
        return lotteries.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotteries lotteries1 = (Lotteries) o;
        return Objects.equals(lotteries, lotteries1.lotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteries);
    }

    @Override
    public String toString() {
        return "Lotteries{" +
                "lotteries=" + lotteries +
                '}';
    }
}
