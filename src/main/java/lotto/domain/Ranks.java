package lotto.domain;


import java.util.ArrayList;
import java.util.List;

import static lotto.common.utils.MathUtil.calculateYield;

/**
 * packageName : lotto.domain
 * fileName : Ranks
 * author : haedoang
 * date : 2021-11-05
 * description : 랭크 리스트 클래스
 */
public class Ranks {
    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = new ArrayList(ranks);
    }

    public long totalRewards() {
        return this.ranks.stream().filter(rank -> !rank.equals(Rank.MISS))
                .mapToInt(rank -> rank.getWinningMoney()).sum();
    }

    public int countPlace(Rank place) {
        return (int) this.ranks.stream().filter(rank -> rank.equals(place)).count();
    }

    public double earningRatio() {
        return calculateYield(this.totalRewards(), ranks.size() * PurchasePrice.LOTTO_PRICE);
    }

}