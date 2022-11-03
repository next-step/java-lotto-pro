package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningTest {

    @ParameterizedTest
    @DisplayName("보너스 볼 매치 여부에 따른 Winning 테스트")
    @CsvSource(value = {"1:true:MISS", "2:true:MISS", "3:true:FIFTH", "4:true:FOURTH", "5:true:SECOND", "6:true:FIRST"
            ,"1:false:MISS", "2:false:MISS", "3:false:FIFTH", "4:false:FOURTH", "5:false:THIRD", "6:false:FIRST"}, delimiter = ':')
    void get_reward_by_matches_test(int matches, boolean matchBonus, Winning winning) {
        assertThat(Winning.valueOf(matches, matchBonus)).isEqualTo(winning);
    }
}
