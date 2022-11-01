package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    void Rank에게_6개_맞춘_경우_등수_물어보기() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void Rank에게_5개_맞추고_보너스볼을_못_맞춘_경우_등수_물어보기() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void Rank에게_5개_맞추고_보너스볼도_맞춘_경우_등수_물어보기() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void Rank에게_4개_맞춘_경우_등수_물어보기() {
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void Rank에게_3개_맞춘_경우_등수_물어보기() {
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }
}
