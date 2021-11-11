package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("당첨갯수와 랭크 상태가 맞는지 검증")
    @Test
    void rankMatch() {
        Rank matchRank = Rank.valueOf(3, false);
        assertThat(matchRank).isEqualTo(Rank.FIFTH);

        matchRank = Rank.valueOf(5, false);
        assertThat(matchRank).isEqualTo(Rank.THIRD);

        matchRank = Rank.valueOf(5, true);
        assertThat(matchRank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("랭크Map 순서에 맞게 나오는지 검증")
    @Test
    void createRankMapTest() {
        Map<Rank, Integer> result = Rank.createRanks();
        assertThat(result.toString()).isEqualTo("{FIFTH=0, FOURTH=0, THIRD=0, SECOND=0, FIRST=0}");
    }

    @DisplayName("당첨갯수가 랭크에 없을 때 검증")
    @Test
    void notMatch() {
        Rank notRank = Rank.valueOf(0, false);
        assertThat(notRank).isEqualTo(Rank.MISS);

        notRank = Rank.valueOf(7, false);
        assertThat(notRank).isEqualTo(Rank.MISS);

        notRank = Rank.valueOf(-1, true);
        assertThat(notRank).isEqualTo(Rank.MISS);
    }
}
