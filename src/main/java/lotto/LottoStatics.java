package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStatics {
    private final List<LottoNumbers> lottoNumbers;
    private final List<Integer> winNumbers;

    public LottoStatics(List<LottoNumbers> lottoNumbers, List<Integer> winNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.winNumbers = winNumbers;
    }

    public LottoPrizeRanks collect() {
        List<LottoPrizeRank> lottoPrizeRankList = new ArrayList<>();
        for (LottoNumbers lottoNumbers : this.lottoNumbers){
            LottoPrizeRank lottoPrizeRank = LottoPrizeRank.find(lottoNumbers.collect(winNumbers));
            lottoPrizeRankList.add(lottoPrizeRank);
        }
        return new LottoPrizeRanks(lottoPrizeRankList);
    }
}
