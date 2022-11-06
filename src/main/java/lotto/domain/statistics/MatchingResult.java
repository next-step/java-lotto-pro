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
import lotto.domain.lotto.WinningNumbers;

public class MatchingResult {
    private final Map<Matches, Long> result;
    private final Money totalSpendAmount;

    public MatchingResult(final Map<Matches, Long> result, final Money totalSpendAmount) {
        this.result = new EnumMap<>(Matches.class);
        initializeAllValuesAsZero();
        this.result.putAll(result);
        this.totalSpendAmount = totalSpendAmount;
    }

    public static MatchingResult analyze(
            final List<Lotto> lottos,
            final Money lottoUnitPrice,
            final WinningNumbers winningNumbers
    ) {
        requireNotNull(lottos, "로또 목록은 null이 아니어야 합니다.");
        requireNotNull(lottoUnitPrice, "로또 단위 가격은 null이 아니어야 합니다.");
        requireNotNull(winningNumbers, "당첨 번호는 null이 아니어야 합니다.");

        final Money totalSpendAmount = lottoUnitPrice.multiply(lottos.size());
        return new MatchingResult(countByMatches(lottos, winningNumbers), totalSpendAmount);
    }

    private static Map<Matches, Long> countByMatches(final List<Lotto> lottos, final WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(winningNumbers::match)
                .collect(groupingBy(identity(), counting()));
    }

    private void initializeAllValuesAsZero() {
        for (Matches matches : Matches.values()) {
            this.result.put(matches, 0L);
        }
    }

    public BigDecimal computeReturnOnInvestment() {
        final BigDecimal quotient = sumPrizes().divide(this.totalSpendAmount);
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

    public Map<Matches, Long> toMap() {
        return this.result;
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
        return result.equals(that.result) && totalSpendAmount.equals(that.totalSpendAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, totalSpendAmount);
    }
}
