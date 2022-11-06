package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;

public enum Matches {
    SIX(new Money(2_000_000_000), (matchCount, __) -> matchCount == 6),
    FIVE_WITH_BONUS(new Money(30_000_000), (matchCount, containsBonus) -> matchCount == 5 && containsBonus),
    FIVE(new Money(1_500_000), (matchCount, containsBonus) -> matchCount == 5 && !containsBonus),
    FOUR(new Money(50_000), (matchCount, __) -> matchCount == 4),
    THREE(new Money(5_000), (matchCount, __) -> matchCount == 3),
    BLANK(Money.ZERO, (matchCount, __) -> true),
    ;

    private static final List<Matches> CHECKLIST = Arrays.asList(Matches.values());
    private final Money prize;
    private final LottoMatchPredicate predicate;

    Matches(final Money prize, final LottoMatchPredicate predicate) {
        this.prize = prize;
        this.predicate = predicate;
    }

    /**
     * @deprecated 이 메서드는 보너스 일치 여부 도입 후 지워질 예정입니다.
     * <p> 대신 {@link Matches#of(long, boolean)}를 사용해 주세요.
     */
    @Deprecated
    public static Matches of(final long matchCount) {
        requireCountInValidRange(matchCount);

        return CHECKLIST.stream()
                .filter((matches -> matches.predicate.test(matchCount, false)))
                .findFirst()
                .orElse(BLANK);
    }

    public static Matches of(final long matchCount, final boolean containsBonusNumber) {
        requireCountInValidRange(matchCount);

        return CHECKLIST.stream()
                .filter(matches -> matches.predicate.test(matchCount, containsBonusNumber))
                .findFirst()
                .orElse(BLANK);
    }

    private static void requireCountInValidRange(long matchCount) {
        if (matchCount < 0 || matchCount > Lotto.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("일치 개수는 로또 길이 이내여야 합니다. value=" + matchCount);
        }
    }

    public Money calculatePrize(Long count) {
        return this.prize.multiply(count);
    }

    public Money getUnitPrize() {
        return this.prize;
    }
}
