package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningResults {

    private final List<WinningResult> winningResults;

    public WinningResults(List<WinningResult> winningResults) {
        this.winningResults = Collections.unmodifiableList(winningResults);
    }

    public static WinningResults of(List<Lotto> lottos, WinningLotto winningLotto) {
        List<WinningResult> winningResults = lottos.stream()
                .map(winningLotto::getWinningResult)
                .filter(winningResult -> winningResult != WinningResult.NOT_MATCHED)
                .collect(Collectors.toList());
        return new WinningResults(winningResults);
    }

    public static WinningResults from(WinningResult... winningResults) {
        return new WinningResults(Arrays.asList(winningResults));
    }

    public List<WinningResult> getWinningResults() {
        return winningResults;
    }

    public long getProceeds() {
        long proceeds = 0;
        for (WinningResult winningResult : winningResults) {
            proceeds += winningResult.getPrize();
        }
        return proceeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningResults that = (WinningResults) o;
        return Objects.equals(winningResults, that.winningResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningResults);
    }
}
