package camp.nextstep.edu.step3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private final Map<Hit, Integer> storage = new HashMap<>();

    public LottoResult(List<Hit> hits) {
        for (Hit hit : hits) {
            increase(hit);
        }
    }

    public EarningsRate earningRate(final LottoMoney money) {
        if (Objects.isNull(money)) {
            throw new IllegalArgumentException("invalid input");
        }
        return money.calculate(totalPrizeAmount());
    }

    private void increase(final Hit hit) {
        if (hit.isWin(Hit.TWO)) {
            storage.put(hit, storage.getOrDefault(hit, 0) + 1);
        }
    }

    private long totalPrizeAmount() {
        return storage.keySet().stream()
                .mapToLong((hit) -> hit.winningAmount(storage.get(hit)))
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult result = (LottoResult) o;
        return Objects.equals(storage, result.storage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storage);
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        for (Hit hit : Hit.winningList()) {
            message.append(printFormat(hit));
        }
        return message.toString();
    }

    private String printFormat(final Hit hit) {
        return String.format(hit + "- %d개\n", storage.getOrDefault(hit, 0));
    }
}
