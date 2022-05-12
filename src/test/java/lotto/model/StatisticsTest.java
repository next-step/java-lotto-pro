package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticsTest {

    @Test
    @DisplayName("로또 숫자리스트와 로또 당첨 번호를 비교하고 당첨된 숫자 갯수를 결과 맵에 count하여 담는다.")
    void 로또숫자비교_test() {
        // given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 11, 22)),
                new Lotto(Arrays.asList(1, 2, 3, 11, 22, 33))
        );
        Lotto win = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        Statistics statistics = new Statistics(win, lottos);

        // then
        assertThat(statistics.getResultMap().get(new Rank(6L))).isEqualTo(2);
        assertThat(statistics.getResultMap().get(new Rank(5L))).isEqualTo(1);
        assertThat(statistics.getResultMap().get(new Rank(4L))).isEqualTo(1);
        assertThat(statistics.getResultMap().get(new Rank(3L))).isEqualTo(1);
    }
}
