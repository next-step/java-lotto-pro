package lotto.domain;

import java.util.List;

public class LottoReport {
    private List<LottoRank> lottoRanks;

    public LottoReport(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public int lottoResultCount(LottoRank searchLottoRank) {
        return (int) lottoRanks.stream()
                .filter((rank) -> rank.equals(searchLottoRank))
                .count();
    }

    public int rewordTotalMoney() {
        int money = 0;
        for (LottoRank lottoRank : lottoRanks) {
            money += lottoRank.rewordMoney();
        }
        return money;
    }

    private int buyTotalMoney() {
        return Lotto.LOTTO_MONEY * lottoRanks.size();
    }

    public double yield() {
        return rewordTotalMoney() / buyTotalMoney();
    }
}
