package lotto.domain;

import java.util.Map;

public class LottoMatchNumberMap {

    private Map<Lotto, Integer> lottoMatchNumberMap;

    public LottoMatchNumberMap(Lotteries lotteries, int[] winningNumbers) {
        this.lottoMatchNumberMap = lotteries.getLottoMatchNumberMap(winningNumbers);
    }

    public int getMatchLottoNumber(int matchNumber) {
        int matchLottoNumber = 0;
        for(Lotto lotto : lottoMatchNumberMap.keySet()) {
            if(lottoMatchNumberMap.get(lotto) == matchNumber) matchLottoNumber++;
        }
        return matchLottoNumber;
    }

}
