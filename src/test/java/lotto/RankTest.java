package lotto;

import static lotto.Rank.FIFTH;
import static lotto.Rank.FIRST;
import static lotto.Rank.FOURTH;
import static lotto.Rank.MISS;
import static lotto.Rank.SECOND;
import static lotto.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    void Rank에게_6개_맞춘_경우_등수_물어보기() {
        assertThat(Rank.valueOf(FIRST.getCountOfMatch(), FIRST.isMatchBonus())).isEqualTo(FIRST);
    }

    @Test
    void Rank에게_5개_맞추고_보너스볼도_맞춘_경우_등수_물어보기() {
        assertThat(Rank.valueOf(SECOND.getCountOfMatch(), SECOND.isMatchBonus())).isEqualTo(SECOND);
    }

    @Test
    void Rank에게_5개_맞추고_보너스볼을_못_맞춘_경우_등수_물어보기() {
        assertThat(Rank.valueOf(THIRD.getCountOfMatch(), THIRD.isMatchBonus())).isEqualTo(THIRD);
    }

    @Test
    void Rank에게_4개_맞춘_경우_등수_물어보기() {
        assertThat(Rank.valueOf(FOURTH.getCountOfMatch(), FOURTH.isMatchBonus())).isEqualTo(FOURTH);
    }

    @Test
    void Rank에게_3개_맞춘_경우_등수_물어보기() {
        assertThat(Rank.valueOf(FIFTH.getCountOfMatch(), FIFTH.isMatchBonus())).isEqualTo(FIFTH);
    }

    @Test
    void Rank에게_0개_맞춘_경우_등수_물어보기() {
        assertThat(Rank.valueOf(MISS.getCountOfMatch(), MISS.isMatchBonus())).isEqualTo(MISS);
    }
}
