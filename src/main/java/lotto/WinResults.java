package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinResults {

    private final List<WinResult> winResults;

    private WinResults(List<WinResult> winResults) {
        this.winResults = winResults;
    }

    public static WinResults of(List<Lotto> lottos, Lotto winNumbers) {
        List<WinResult> winResults = lottos.stream()
                .map(lotto -> lotto.getWinResult(winNumbers))
                .collect(Collectors.toList());
        return new WinResults(winResults);
    }

    public static WinResults from(WinResult... winResults) {
        return new WinResults(Arrays.asList(winResults));
    }

    public int getCount(int matchedCount) {
        WinResult findWinResult = WinResult.fromCount(matchedCount);
        return (int) winResults.stream()
                .filter(winResult -> winResult == findWinResult)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinResults that = (WinResults) o;
        return Objects.equals(winResults, that.winResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winResults);
    }

    public long getProceeds() {
        long proceeds = 0;
        for (WinResult winResult : winResults) {
            proceeds += winResult.getPrize();
        }
        return proceeds;
    }
}
