package lotto.domain;

import java.util.ArrayList;
import java.util.List;

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

    public int countPlace(Rank findRank) {
        return (int) this.rankList.stream().filter(rank -> rank.equals(findRank)).count();
    }
}
