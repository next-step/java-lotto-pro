package lotto.domain;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import generic.Money;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class LottoWinResultGroup {
    private final List<LottoWinResult> winResultList;
    private final Map<LottoWinResult, Long> group;

    public LottoWinResultGroup(final List<LottoWinResult> winResultList) {
        this.winResultList = winResultList;
        this.group = winResultList.stream()
                .collect(groupingBy(identity(), counting()));
    }

    public Money totalWinningPrice() {
        Money total = Money.ZERO;
        for (Entry<LottoWinResult, Long> lottoWinResultLongEntry : group.entrySet()) {
            total = total.plus(lottoWinResultLongEntry.getKey().price(lottoWinResultLongEntry.getValue()));
        }

        return total;
    }

    public long countByWinResult(final LottoWinResult lottoWinResult) {
        return this.group.getOrDefault(lottoWinResult, 0L);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoWinResultGroup)) {
            return false;
        }
        final LottoWinResultGroup that = (LottoWinResultGroup) o;
        return Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group);
    }

    @Override
    public String toString() {
        return "LottoWinResultGroup{" +
                "winResultList=" + winResultList +
                ", group=" + group +
                '}';
    }
}
