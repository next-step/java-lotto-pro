package lotto.utils;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.enums.WinningRank;

public class LottoWinningRankMatcher {

    private LottoWinningRankMatcher() {}

    public static WinningRank match(LottoNumbers lastWeekWinningNumber, LottoNumber bonusBallNumber, LottoNumbers lottoNumbers) {
        int matchCount = (int) lottoNumbers.getReadOnlyLottoNumbers()
            .stream()
            .filter(lastWeekWinningNumber::contains)
            .count();

        return WinningRank.valueOf(matchCount, lottoNumbers.hasBonusBallNumber(bonusBallNumber));
    }
}
