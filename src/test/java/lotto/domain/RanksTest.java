package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @Test
    @DisplayName("Ranks에 Rank를 추가하는 작업이 정상적으로 동작한다.")
    public void add() {
        Ranks ranks = new Ranks();

        ranks.add(Rank.FIRST);

        assertThat(ranks.getCountsOfRanks()).containsEntry(Rank.FIRST, 1);
    }
}
