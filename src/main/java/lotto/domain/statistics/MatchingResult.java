package lotto.domain.statistics;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static lotto.utils.Validations.requireNotNull;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Matches;

public class MatchingResult {
    private final Map<Matches, Long> result = new EnumMap<>(Matches.class);
    ;

    public MatchingResult(final Map<Matches, Long> result) {
        initializeAllValuesAsZero(result);
        this.result.putAll(result);
    }

    private static void initializeAllValuesAsZero(Map<Matches, Long> result) {
        for (Matches matches : Matches.values()) {
            result.put(matches, 0L);
        }
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
