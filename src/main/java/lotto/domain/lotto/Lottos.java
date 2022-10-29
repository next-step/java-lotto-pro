package lotto.domain.lotto;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoConstant;
import lotto.domain.win.WinRanking;

public class Lottos {
    private final List<Lotto> values;

    private Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos from(List<Lotto> values) {
        return new Lottos(values);
    }

    public int size() {
        return this.values.size();
    }

    public int winningCount(List<LottoNumber> winningNumbers, int expectedMatchCount) {
        int matchCount = 0;
        for (Lotto lotto : values) {
            matchCount = getMatchCount(lotto, winningNumbers, expectedMatchCount, matchCount);
        }
        return matchCount;
    }

    private int getMatchCount(Lotto lotto, List<LottoNumber> winningNumbers, int expectedMatchCount, int matchCount) {
        if (lotto.matches(winningNumbers) == expectedMatchCount) {
            matchCount++;
        }
        return matchCount;
    }

    public Map<WinRanking, Integer> winResults(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        Map<WinRanking, Integer> winningCountByWinRanking = new EnumMap<>(WinRanking.class);

        for (Lotto lotto : values) {
            WinRanking winRanking = WinRanking.of(lotto.matches(winningNumbers), lotto.hasBonusNumber(bonusNumber));
            int count = winningCountByWinRanking.getOrDefault(winRanking, LottoConstant.EMPTY_WINNING_COUNT);
            winningCountByWinRanking.put(winRanking, count + 1);
        }

        return winningCountByWinRanking;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(values);
    }
}
