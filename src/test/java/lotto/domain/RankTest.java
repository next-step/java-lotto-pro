package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("당첨 개수에 따른 당첨 금액 조회 작업이 정상적으로 동작한다.")
    @ParameterizedTest(name = "{index} ) {displayName} [{arguments}]")
    @CsvSource(value = {"6:false:2000000000", "5:true:30000000", "5:false:1500000",
            "4:false:50000", "3:false:5000", "2:false:0", "1:false:0", "0:false:0"}, delimiter = ':')
    public void valueOf(int matchBallCount, boolean isMatchBonusBall, int winningMoney) {
        Rank rank = Rank.valueOf(new MatchCount(matchBallCount, isMatchBonusBall));

        assertThat(rank.getWinningMoney()).isEqualTo(winningMoney);
    }
}
