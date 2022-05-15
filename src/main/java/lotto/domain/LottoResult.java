package lotto.domain;

import lotto.enums.LottoRank;

public class LottoResult {

    public static double lottoGameEarningsRate(int money, LottoRanks lottoRanks) {
        return (double) totalPrizeMoney(lottoRanks) / money;
    }

    private static int totalPrizeMoney(LottoRanks lottoRanks) {
        return lottoRanks.getLottoRanks().stream().mapToInt(LottoRank::getPrizeMoney).sum();
    }
}
