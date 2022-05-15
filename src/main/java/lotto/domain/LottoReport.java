package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoReport {
    private final List<LottoRank> lottoRanks;
    private static final int BREAK_EVEN_POINT = 1;

    public LottoReport(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
        Collections.sort(lottoRanks);
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

    public double yield() {
        return rewordTotalMoney() / buyTotalMoney();
    }

    public boolean isBenefit() {
        return this.yield() > BREAK_EVEN_POINT;
    }

    private int buyTotalMoney() {
        return Lotto.LOTTO_MONEY * lottoRanks.size();
    }


}
