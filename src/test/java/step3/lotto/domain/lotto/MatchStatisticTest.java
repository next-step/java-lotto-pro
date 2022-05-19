package step3.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : choi-ys
 * @date : 2022/05/19 12:30 오전
 */
@DisplayName("Domain:MatchStatistic")
class MatchStatisticTest {

    @Test
    @DisplayName("1~5등 까지의 당첨 결과를 기반으로 산출된 통계 검증")
    public void assertionsMatchStatistic_ThroughGivenMatchResults() {
        // Given & When
        MatchStatistic matchStatistic = new MatchStatistic();
        matchStatistic.add(MatchResult.FIRST_PLACE);
        matchStatistic.add(MatchResult.SECOND_PLACE);
        matchStatistic.add(MatchResult.THIRD_PLACE);
        matchStatistic.add(MatchResult.FORTH_PLACE);
        matchStatistic.add(MatchResult.FIFTH_PLACE);
        matchStatistic.add(MatchResult.NOTHING);

        // When & Then
        assertAll(
            () -> assertThat(matchStatistic.getFirstPlaceCount()).isEqualTo(1),
            () -> assertThat(matchStatistic.getSecondPlaceCount()).isEqualTo(1),
            () -> assertThat(matchStatistic.getThirdPlaceCount()).isEqualTo(1),
            () -> assertThat(matchStatistic.getForthPlaceCount()).isEqualTo(1),
            () -> assertThat(matchStatistic.getFifthPlaceCount()).isEqualTo(1),
            () -> assertThat(matchStatistic.getRateOfProfit()).isEqualTo(334092.5)
        );
    }
}
