package lotto.domain.statistics;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static lotto.utils.Validations.requireNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Matches;
import lotto.domain.lotto.Money;

public class MatchingResult {
    private final Map<Matches, Long> result;

    public MatchingResult(final Map<Matches, Long> result) {
        this.result = new EnumMap<>(Matches.class);
        initializeAllValuesAsZero();
        this.result.putAll(result);
    }

    public static MatchingResult matches(final List<Lotto> lottos, final Lotto winningNumbers) {
        requireNotNull(lottos, "로또 목록은 null이 아니어야 합니다.");
        requireNotNull(winningNumbers, "당첨 번호는 null이 아니어야 합니다.");

        return new MatchingResult(countByMatches(lottos, winningNumbers));
    }

    private static Map<Matches, Long> countByMatches(final List<Lotto> lottos, final Lotto winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.match(winningNumbers))
                .collect(groupingBy(identity(), counting()));
    }

    private void initializeAllValuesAsZero() {
        for (Matches matches : Matches.values()) {
            this.result.put(matches, 0L);
        }
    }

    public BigDecimal computeReturnOnInvestment(final Money totalAmount) {
        final BigDecimal quotient = sumPrizes().divide(totalAmount);
        return quotient.setScale(2, RoundingMode.HALF_EVEN);
    }

    private Money sumPrizes() {
        return result.entrySet()
                .stream()
                .map(this::calculatePrize)
                .reduce(Money.ZERO, Money::plus);
    }

    private Money calculatePrize(final Entry<Matches, Long> matchesToCount) {
        final Matches match = matchesToCount.getKey();
        final long matchCount = matchesToCount.getValue();
        return match.calculatePrize(matchCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchingResult that = (MatchingResult) o;
        return result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
