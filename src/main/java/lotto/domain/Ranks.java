package lotto.domain;

import lotto.common.Constants;
import lotto.ui.ResultView;

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

    public void print() {
        ResultView.print(Constants.MSG_OUTPUT_LOTTO_RESULT);
        ResultView.print(Constants.MSG_OUTPUT_LINE_SEPARATOR);
        ResultView.print(getPlaceMessage(Rank.FIFTH));
        ResultView.print(getPlaceMessage(Rank.FOURTH));
        ResultView.print(getPlaceMessage(Rank.THIRD));
        ResultView.print(getPlaceMessage(Rank.SECOND));
        ResultView.print(getPlaceMessage(Rank.FIRST));
        ResultView.print(Constants.MSG_OUTPUT_YIELD_PREFIX + this.earningRatio() + Constants.MSG_OUTPUT_YIELD_SUFFIX);
    }

    private String getPlaceMessage(Rank rank) {
        return new StringBuilder()
                .append(rank.getCountOfMatch())
                .append(rank.equals(Rank.SECOND) ? Constants.MSG_OUTPUT_PLACE_PREFIX_BONUS : Constants.MSG_OUTPUT_PLACE_PREFIX)
                .append(rank.getWinningMoney()).append(Constants.MSG_OUTPUT_PLACE_SUFFIX).append(this.countPlace(rank)).append(Constants.MSG_OUTPUT_SUFFIX).toString();
    }

}