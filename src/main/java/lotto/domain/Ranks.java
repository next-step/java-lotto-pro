package lotto.domain;

import lotto.common.Constants;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.MathUtil.calculateYield;

/**
 * packageName : lotto.domain
 * fileName : Ranks
 * author : haedoang
 * date : 2021-11-05
 * description : 랭크 리스트 클래스
 *
 */
public class Ranks {
    private final List<Rank> rankList;

    public Ranks(List<Rank> rankList) {
        if (rankList == null) throw new NullPointerException("null값이 올 수 없습니다.");
        if (rankList.isEmpty()) throw new IllegalArgumentException("빈 값이 올 수 없습니다.");
        this.rankList = new ArrayList<>(rankList);
    }

    public long countPlace(Rank findRank) {
        return  this.rankList.stream().filter(rank -> rank.equals(findRank)).count();
    }

    public long totalRewards() {
        return countPlace(new Rank(Rank.FIRST_PLACE_MATCH_COUNT)) * Constants.REWARD_1ST +
                countPlace(new Rank(Rank.SECOND_PLACE_MATCH_COUNT)) * Constants.REWARD_2ND +
                countPlace(new Rank(Rank.THIRD_PLACE_MATCH_COUNT)) * Constants.REWARD_3RD +
                countPlace(new Rank(Rank.FOURTH_PLACE_MATCH_COUNT)) * Constants.REWARD_4TH;
    }
    public double earningRatio() {
        return calculateYield(this.totalRewards(), rankList.size() * PurchasePrice.LOTTO_PRICE);
    }
}
