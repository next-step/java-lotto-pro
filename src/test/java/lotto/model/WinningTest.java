package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {
    @ParameterizedTest
    @EnumSource(Winning.class)
    void ofMatchCount(Winning givenWinning) {
        final Winning winning = Winning.ofMatchCount(givenWinning.getMatchCount());
        assertThat(winning.getReward()).isEqualTo(givenWinning.getReward());
    }
}
