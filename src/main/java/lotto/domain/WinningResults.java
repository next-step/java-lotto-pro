package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningResults {

    private final List<WinningResult> winningResults;

    private WinningResults(List<WinningResult> winningResults) {
        this.winningResults = Collections.unmodifiableList(winningResults);
    }

    public static WinningResults of(List<Lotto> lottos, Lotto winNumber, LottoNumber bonusNumber) {
        List<WinningResult> winningResults = lottos.stream()
                .map(lotto -> lotto.getWinningResult(winNumber, bonusNumber))
                .filter(winningResult -> winningResult != WinningResult.NOT_MATCHED)
                .collect(Collectors.toList());
        return new WinningResults(winningResults);
    }

    public static WinningResults from(WinningResult... winningResults) {
        return new WinningResults(Arrays.asList(winningResults));
    }

    public int getCount(WinningResult findingWinningResult) {
        return (int) winningResults.stream()
                .filter(winningResult -> winningResult == findingWinningResult)
                .count();
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
