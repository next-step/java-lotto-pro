package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @Test
    @DisplayName("Rank 추가 성공")
    public void add() {
        Ranks ranks = new Ranks();

        ranks.add(Rank.FIRST);

        assertThat(ranks.getCountsOfRanks()).containsEntry(Rank.FIRST, 1);
    }
}
