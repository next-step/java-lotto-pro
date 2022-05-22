package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void 로또_2등_결과_확인() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void 로또_등수없음_결과_확인() {
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
    }

}
