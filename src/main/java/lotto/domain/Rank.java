package lotto.domain;

import java.util.Objects;

/**
 * packageName : lotto.domain
 * fileName : Rank
 * author : haedoang
 * date : 2021-11-05
 * description : 순위 클래스
 */
public class Rank {
    public static final int FIRST_PLACE = 1;
    public static final int SECOND_PLACE = 2;
    public static final int THIRD_PLACE = 3;
    public static final int FOURTH_PLACE = 4;
    public static final int OTHERS_PLACE = 0;

    public static final int FIRST_PLACE_MATCH_COUNT = 6;
    public static final int SECOND_PLACE_MATCH_COUNT = 5;
    public static final int THIRD_PLACE_MATCH_COUNT = 4;
    public static final int FOURTH_PLACE_MATCH_COUNT = 3;

    private final int place;

    public Rank(int matchCount) {
        this.place = getRank(matchCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return place == rank.place;
    }

    @Override
    public int hashCode() {
        return Objects.hash(place);
    }

    private int getRank(int matchCount) {
        return matchCount == FIRST_PLACE_MATCH_COUNT ? FIRST_PLACE :
                matchCount == SECOND_PLACE_MATCH_COUNT ? SECOND_PLACE :
                        matchCount == THIRD_PLACE_MATCH_COUNT ? THIRD_PLACE :
                                matchCount == FOURTH_PLACE_MATCH_COUNT ? FOURTH_PLACE : OTHERS_PLACE;
    }


}
