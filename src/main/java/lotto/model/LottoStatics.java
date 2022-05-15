package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoStatics {
    private final List<LottoNumbers> lottoNumbers;
    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public LottoStatics(List<LottoNumbers> lottoNumbers, List<Integer> winNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoPrizeRanks collect() {
        List<LottoPrizeRank> lottoPrizeRankList = new ArrayList<>();
        for (LottoNumbers lottoNumbers : this.lottoNumbers) {
            LottoPrizeRank lottoPrizeRank = LottoPrizeRank.find(lottoNumbers.collect(winNumbers));
            lottoPrizeRank = checkBonus(lottoPrizeRank, lottoNumbers);
            lottoPrizeRankList.add(lottoPrizeRank);
        }
        return new LottoPrizeRanks(lottoPrizeRankList);
    }

    private LottoPrizeRank checkBonus(LottoPrizeRank lottoPrizeRank, LottoNumbers lottoNumbers) {
        if (lottoPrizeRank.equals(LottoPrizeRank.THIRD) && lottoNumbers.hasBonus(bonusNumber)) {
            return upgradeSecond();
        }
        return lottoPrizeRank;
    }

    private LottoPrizeRank upgradeSecond() {
        return LottoPrizeRank.SECOND;
    }
}
