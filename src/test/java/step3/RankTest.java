package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Rank;

public class RankTest {

    @Test
    @DisplayName("매치 카운트에 따른 랭크 값을 출력하는 테스트")
    void rankTest() {
        Rank rank = Rank.from(3);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

}
