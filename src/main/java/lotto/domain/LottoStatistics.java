package lotto.domain;

import java.util.List;

public class LottoStatistics {

    public static List<LottoRank> filter(List<LottoRank> lottoRanks) {
        return LottoRank.filteredHasPrize(lottoRanks);
    }
}
