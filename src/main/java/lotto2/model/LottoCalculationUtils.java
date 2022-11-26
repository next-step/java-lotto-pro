package lotto2.model;

import lotto2.model.enums.WinningRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculationUtils {
    public Map<WinningRank, Integer> initializeCountMap() {
        final Map<WinningRank, Integer> countForEachWinningRank = new HashMap<>();
        countForEachWinningRank.put(WinningRank.FIFTH, 0);
        countForEachWinningRank.put(WinningRank.FOURTH, 0);
        countForEachWinningRank.put(WinningRank.THIRD, 0);
        countForEachWinningRank.put(WinningRank.SECOND, 0);
        countForEachWinningRank.put(WinningRank.FIRST, 0);
        return countForEachWinningRank;
    }

    public int getMatchCount(Lotto eachLotto, Lotto winningNumbers) {
        final List<LottoNumber> lottoWinningNumbers = winningNumbers.lottoNumbers();
        int matchCount = 0;
        for (LottoNumber currentWinningNumber : lottoWinningNumbers) {
            if (eachLotto.contains(currentWinningNumber)) {
                ++matchCount;
            }
        }
        return matchCount;
    }

    public WinningRank winningRankForMatchCount(int matchCount, boolean containsBonusNumber) {
        if (matchCount == 3) {
            return WinningRank.FIFTH;
        }
        if (matchCount == 4) {
            if (containsBonusNumber) {
                return WinningRank.SECOND;
            }
            return WinningRank.FOURTH;
        }
        if (matchCount == 5) {
            return WinningRank.THIRD;
        }
        if (matchCount == 6) {
            return WinningRank.FIRST;
        }
        return WinningRank.NONE;
    }

    public Map<WinningRank, Integer> setCountForEachWinningRank(
            Map<WinningRank, Integer> countMap,
            WinningRank winningRank) {
        final Map<WinningRank, Integer> countForEachWinningRank = new HashMap<>(countMap);
        final int count = countForEachWinningRank.get(winningRank);
        countForEachWinningRank.put(winningRank, count + 1);
        return countForEachWinningRank;
    }
}
