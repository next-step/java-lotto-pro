package play.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    @DisplayName("매칭카운트에 따른 Rank값을 출력하는 테스트")
    void rankTest() {
        Rank rank = Rank.getRank(3);
        assertThat(rank).isEqualTo(Rank.FORTH);
    }
}
