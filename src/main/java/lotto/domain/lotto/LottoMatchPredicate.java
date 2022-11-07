package lotto.domain.lotto;

@FunctionalInterface
public interface LottoMatchPredicate {
    boolean test(final long matchCount, final boolean containsBonus);
}
