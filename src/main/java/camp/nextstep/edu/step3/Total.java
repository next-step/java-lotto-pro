package camp.nextstep.edu.step3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Total {
    private final Map<Hit, Integer> totalHitMap = new HashMap<>();

    public Total(Hit... hits) {
        initMap();
        for (Hit hit : hits) {
            increase(hit);
        }
    }

    private void initMap() {
        Arrays.stream(Hit.values())
                .filter(Hit.TWO::isLow)
                .forEach(hit -> totalHitMap.put(hit, 0));
    }

    public EarningsRate result(final int amount) {
        return new EarningsRate(totalPrizeAmount(), amount);
    }

    private void increase(final Hit hit) {
        if (Hit.TWO.isLow(hit)) {
            totalHitMap.put(hit, totalHitMap.get(hit) + 1);
        }
    }

    private double totalPrizeAmount() {
        return totalHitMap.keySet().stream()
                .mapToDouble((hit) -> hit.cost(totalHitMap.get(hit)))
                .sum();
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

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        for (Hit hit : sortedKey()) {
            message.append(printFormat(hit));
        }
        return message.toString();
    }

    private Hit[] sortedKey() {
        return totalHitMap.keySet().stream().sorted().toArray(Hit[]::new);
    }

    private String printFormat(final Hit hit) {
        return String.format(hit + "- %d개\n", totalHitMap.getOrDefault(hit, 0));
    }
}
