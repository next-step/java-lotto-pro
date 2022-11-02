package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningTest {

    @ParameterizedTest
    @DisplayName("로또 숫자 일치 개수에 따른 당첨금 확인 테스트")
    @CsvSource(value = {"1:0", "2:0", "3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void get_reward_by_matches_test(int matches, int reward) {
        assertThat(Winning.getRewardsByMatch(matches)).isEqualTo(reward);
    }
}
