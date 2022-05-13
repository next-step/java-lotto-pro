package camp.nextstep.edu.step3;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Statistics {
    private final Map<Hit, Integer> prizeHitMap = new HashMap<>();
    public Statistics(Hit ... hits) {
        for (Hit hit : hits) {
            increase(hit);
        }
    }

    private void increase(final Hit hit) {
        if (Hit.TWO.isLow(hit)) {
            prizeHitMap.put(hit,prizeHitMap.getOrDefault(hit, 0) + 1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return Objects.equals(prizeHitMap, that.prizeHitMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeHitMap);
    }
}
