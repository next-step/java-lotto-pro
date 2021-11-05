package lotto.domain;

import com.sun.tools.internal.jxc.ap.Const;
import javafx.scene.control.TableView;
import lotto.common.Constants;
import lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.MathUtil.calculateYield;

/**
 * packageName : lotto.domain
 * fileName : Ranks
 * author : haedoang
 * date : 2021-11-05
 * description : 랭크 리스트 클래스
 */
public class Ranks {
    private final List<Rank> rankList;

    public Ranks(List<Rank> rankList) {
        if (rankList == null) throw new NullPointerException("null값이 올 수 없습니다.");
        if (rankList.isEmpty()) throw new IllegalArgumentException("빈 값이 올 수 없습니다.");
        this.rankList = new ArrayList<>(rankList);
    }

    public long countPlace(Rank findRank) {
        return this.rankList.stream().filter(rank -> rank.equals(findRank)).count();
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

    public void print() {
        ResultView.print(Constants.MSG_OUTPUT_LOTTO_RESULT);
        ResultView.print(Constants.MSG_OUTPUT_LINE_SEPARATOR);
        ResultView.print(Constants.MSG_OUTPUT_4TH_PREFIX + this.countPlace(new Rank(Rank.FOURTH_PLACE_MATCH_COUNT)) + Constants.MSG_OUTPUT_SUFFIX);
        ResultView.print(Constants.MSG_OUTPUT_3RD_PREFIX + this.countPlace(new Rank(Rank.THIRD_PLACE_MATCH_COUNT)) + Constants.MSG_OUTPUT_SUFFIX);
        ResultView.print(Constants.MSG_OUTPUT_2ND_PREFIX + this.countPlace(new Rank(Rank.SECOND_PLACE_MATCH_COUNT)) + Constants.MSG_OUTPUT_SUFFIX);
        ResultView.print(Constants.MSG_OUTPUT_1ST_PREFIX + this.countPlace(new Rank(Rank.FIRST_PLACE_MATCH_COUNT)) + Constants.MSG_OUTPUT_SUFFIX);
        ResultView.print(Constants.MSG_OUTPUT_YIELD_PREFIX + this.earningRatio() + Constants.MSG_OUTPUT_YIELD_SUFFIX);
    }
}
