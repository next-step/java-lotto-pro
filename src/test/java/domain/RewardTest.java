package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RewardTest {

    private static Stream<Arguments> provideReward() {
        return Stream.of(
          Arguments.of(6, Reward.FIRST),
          Arguments.of(5, Reward.SECOND),
          Arguments.of(4, Reward.THIRD),
          Arguments.of(3, Reward.FOURTH),
          Arguments.of(2, Reward.MISS),
          Arguments.of(1, Reward.MISS),
          Arguments.of(0, Reward.MISS)
        );
    }

    @DisplayName("일치 갯수에 따른 보상을 응답한다.")
    @MethodSource(value = "provideReward")
    @ParameterizedTest
    void valueOf(int matches, Reward expected) {
        assertThat(Reward.of(matches)).isEqualTo(expected);
    }
}
