package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class WinningLotto {

    private final LottoNumber matchNumber;
    private final Number bonusNumber;

    public WinningLotto(LottoNumber matchNumber, Number bonusNumber) {
        this.matchNumber = matchNumber;
        this.bonusNumber = bonusNumber;
    }

    public boolean isExistBonusNumber(List<Number> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public boolean isMatchNumber(Number lottoNumber) {
        return matchNumber.isContains(lottoNumber);
    }

    public LottoResult getLottoMatchResult(List<LottoNumber> lottoList) {
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);

        for (LottoNumber lotto : lottoList) {
            Rank matchRank = lotto.getMatchRank(this);
            result.put(matchRank, result.getOrDefault(matchRank, 0) + 1);
        }

        return new LottoResult(result);
    }

}
