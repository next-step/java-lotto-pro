package camp.nextstep.edu.step3;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class EarningsRate {
    private final double rate;

    public EarningsRate(final double totalPrizeAmount, final int userBuyAmount) {
        this.rate =  Math.floor((totalPrizeAmount / userBuyAmount) * 100) / 100.0;
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
       return String.format("총 수익률은 %.2f입니다.%s",this.rate, messageType());
    }

    private String messageType() {
        if (this.rate == 1) {
            return "(기준이 1이기 때문에 결과적으로 같다라는 의미임)";
        }
        if (this.rate < 1) {
            return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)";
    }
}
