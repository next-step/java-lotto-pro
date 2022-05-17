package step3.lotto.domain.lotto;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : choi-ys
 * @date : 2022/05/17 1:53 오후
 */
@DisplayName("Domain:Lottos")
public class LottosTest {

    @Test
    @DisplayName("N번의 로또 게임의 당첨 통계 반환")
    public void returnMatchResults_GivenLottos() {
        // Given
        Lottos lottos = new Lottos(Arrays.asList(
            Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7)),
            Lotto.of(Arrays.asList(1, 2, 3, 4, 7, 8)),
            Lotto.of(Arrays.asList(1, 2, 3, 7, 8, 9)),
            Lotto.of(Arrays.asList(1, 2, 7, 8, 9, 10)),
            Lotto.of(Arrays.asList(1, 7, 8, 9, 10, 11)),
            Lotto.of(Arrays.asList(7, 8, 9, 10, 11, 12))
        ));
        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        // When
        MatchStatistic matchStatistic = lottos.match(winningLotto);

        // Then
        assertAll(
            () -> assertThat(matchStatistic.getFirstPlaceCount()).as("6개 일치 수").isEqualTo(1),
            () -> assertThat(matchStatistic.getSecondPlaceCount()).as("5개 일치 수").isEqualTo(1),
            () -> assertThat(matchStatistic.getThirdPlaceCount()).as("4개 일치 수").isEqualTo(1),
            () -> assertThat(matchStatistic.getForthPlaceCount()).as("3개 일치 수").isEqualTo(1),
            () -> assertThat(matchStatistic.getRateOfProfit()).as("수익률").isEqualTo(285936.42)
        );
    }
}
