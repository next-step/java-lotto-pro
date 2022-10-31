package lotto.domain;

import java.util.Map;

public class LottoNumberMatcher {

    private Map<Lotto, Integer> lottoNumberMatcher;

    public LottoNumberMatcher(Lotteries lotteries, WinningNumbers winningNumbers) {
        this.lottoNumberMatcher = lotteries.getLottoMatchNumberMap(winningNumbers);
    }

    public int getMatchLottoNumber(int matchNumber) {
        return (int) lottoNumberMatcher.keySet().stream()
                .filter(lotto -> lottoNumberMatcher.get(lotto) == matchNumber)
                .count();
    }

}
