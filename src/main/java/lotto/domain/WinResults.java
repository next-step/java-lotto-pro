package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinResults {

    private final List<WinResult> winResults;

    private WinResults(List<WinResult> winResults) {
        this.winResults = Collections.unmodifiableList(winResults);
    }

    public static WinResults of(List<Lotto> lottos, Lotto winNumber, LottoNumber bonusNumber) {
        List<WinResult> winResults = lottos.stream()
                .map(lotto -> lotto.getWinResult(winNumber, bonusNumber))
                .filter(winResult -> winResult != WinResult.NOT_MATCHED)
                .collect(Collectors.toList());
        return new WinResults(winResults);
    }

    public static WinResults from(WinResult... winResults) {
        return new WinResults(Arrays.asList(winResults));
    }

    public int getCount(WinResult findingWinResult) {
        return (int) winResults.stream()
                .filter(winResult -> winResult == findingWinResult)
                .count();
    }

    public long getProceeds() {
        long proceeds = 0;
        for (WinResult winResult : winResults) {
            proceeds += winResult.getPrize();
        }
        return proceeds;
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
}
