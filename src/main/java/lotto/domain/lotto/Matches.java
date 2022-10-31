package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public enum Matches {
    SIX((matchCount) -> matchCount == 6),
    FIVE((matchCount) -> matchCount == 5),
    FOUR((matchCount) -> matchCount == 4),
    THREE((matchCount) -> matchCount == 3),
    BLANK((matchCount) -> true),
    ;

    private static final List<Matches> CHECKLIST = Arrays.asList(Matches.values());
    private final Predicate<Long> predicate;

    Matches(final Predicate<Long> predicate) {
        this.predicate = predicate;
    }

    public static Matches of(final long matchCount) {
        requireCountInValidRange(matchCount);

        return CHECKLIST.stream()
                .filter((matches -> matches.predicate.test(matchCount)))
                .findFirst()
                .orElse(BLANK);
    }

    private static void requireCountInValidRange(long matchCount) {
        if (matchCount < 0 || matchCount > Lotto.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("일치 개수는 로또 길이 이내여야 합니다. value=" + matchCount);
        }
    }
}
