package camp.nextstep.edu.step3;

import java.util.Objects;

public class EarningsRate {
    private final double rate;

    public EarningsRate(final double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EarningsRate that = (EarningsRate) o;
        return Double.compare(that.rate, rate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }

    @Override
    public String toString() {
       return String.format("총 수익률은 %.2f입니다.%s",this.rate, explanation());
    }

    private String explanation() {
        if (this.rate == 1) {
            return "(기준이 1이기 때문에 결과적으로 같다라는 의미임)";
        }
        if (this.rate < 1) {
            return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)";
    }
}
