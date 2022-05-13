package camp.nextstep.edu.step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Total{
    private final Map<Hit, Integer> totalHitMap = new HashMap<>();
    public Total(Hit ... hits) {
        for (Hit hit : hits) {
            increase(hit);
        }
    }

    private void increase(final Hit hit) {
        if (Hit.TWO.isLow(hit)) {
            totalHitMap.put(hit, totalHitMap.getOrDefault(hit, 0) + 1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Total total = (Total) o;
        return Objects.equals(totalHitMap, total.totalHitMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalHitMap);
    }
}
