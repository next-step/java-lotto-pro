package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("당첨갯수와 랭크 상태가 맞는지 검증")
    @Test
    void rankMatch() {
        Rank matchRank = Rank.valueOf(3);
        assertThat(matchRank).isEqualTo(Rank.FOURTH);
        assertThat(matchRank).isEqualTo(Rank.FOURTH);

        matchRank = Rank.valueOf(5);
        assertThat(matchRank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("당첨갯수가 랭크에 없을 때 검증")
    @Test
    void notMatch() {
        Rank notRank = Rank.valueOf(0);
        assertThat(notRank).isEqualTo(Rank.MISS);

        notRank = Rank.valueOf(7);
        assertThat(notRank).isEqualTo(Rank.MISS);

        notRank = Rank.valueOf(-1);
        assertThat(notRank).isEqualTo(Rank.MISS);
    }

}
