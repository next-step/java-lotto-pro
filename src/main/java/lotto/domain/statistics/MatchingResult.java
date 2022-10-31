package lotto.domain.statistics;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Matches;

public class MatchingResult {
    private final Map<Matches, Long> result;

    public MatchingResult(final Map<Matches, Long> result) {
        this.result = result;
    }

    public MatchingResult(final List<Lotto> lottos, final Lotto winningNumbers) {
        requireNotNull(lottos, "로또 목록은 null이 아니어야 합니다.");
        requireNotNull(winningNumbers, "당첨 번호는 null이 아니어야 합니다.");

        this.result = countByMatches(lottos, winningNumbers);
    }

    private Map<Matches, Long> countByMatches(final List<Lotto> lottos, final Lotto winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.match(winningNumbers))
                .collect(groupingBy(identity(), counting()));
    }

    private void requireNotNull(final Object object, final String errorMessage) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException(errorMessage);
        }
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
