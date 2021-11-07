package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningLotto {

    private final List<Number> matchNumber;
    private final Number bonusNumber;

    public WinningLotto(List<Number> matchNumber, Number bonusNumber) {
        this.matchNumber = matchNumber;
        this.bonusNumber = bonusNumber;
    }

    public boolean isExistBonusNumber(List<Number> lottoNumbers) {
        return Collections.frequency(lottoNumbers, bonusNumber) > 0 ? true : false;
    }

    public boolean isMatchNumber(Number lottoNumber) {
        return Collections.frequency(matchNumber, lottoNumber) > 0 ? true : false;
    }

    public LottoResult getLottoMatchResult(List<LottoNumber> lottoList) {
        Map<Rank, Integer> result = new HashMap<>();

        for (LottoNumber lotto : lottoList) {
            Rank matchRank = lotto.getMatchRank(this);
            result.put(matchRank, result.getOrDefault(matchRank, 0) + 1);
        }

        return new LottoResult(result);
    }

}
