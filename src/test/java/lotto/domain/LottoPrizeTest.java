package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoPrizeTest {

    @DisplayName("valueOf 1등 테스트")
    @ParameterizedTest(name = "{displayName}{index} -> matchBonus: {0}")
    @ValueSource(booleans = {true, false})
    void valueOf_firstPlace(boolean matchBonus) {
        // given
        int matchCount = LottoPrize.FIRST_PLACE.getMatchCount();

        // when
        LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, matchBonus);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.FIRST_PLACE);
    }

    @DisplayName("valueOf 2등 테스트")
    @Test
    void valueOf_secondPlace() {
        // given
        int matchCount = LottoPrize.SECOND_PLACE.getMatchCount();
        boolean matchBonus = true;

        // when
        LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, matchBonus);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.SECOND_PLACE);
    }

    @DisplayName("valueOf 3등 테스트")
    @Test
    void valueOf_thirdPlace() {
        // given
        int matchCount = LottoPrize.THIRD_PLACE.getMatchCount();
        boolean matchBonus = false;

        // when
        LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, matchBonus);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.THIRD_PLACE);
    }

    @DisplayName("valueOf 4등 테스트")
    @ParameterizedTest(name = "{displayName}{index} -> matchBonus: {0}")
    @ValueSource(booleans = {true, false})
    void valueOf_fourthPlace(boolean matchBonus) {
        // given
        int matchCount = LottoPrize.FOURTH_PLACE.getMatchCount();

        // when
        LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, matchBonus);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.FOURTH_PLACE);
    }

    @DisplayName("valueOf 5등 테스트")
    @ParameterizedTest(name = "{displayName}{index} -> matchBonus: {0}")
    @ValueSource(booleans = {true, false})
    void valueOf_fifthPlace(boolean matchBonus) {
        // given
        int matchCount = LottoPrize.FIFTH_PLACE.getMatchCount();

        // when
        LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, matchBonus);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.FIFTH_PLACE);
    }

    @DisplayName("valueOf 낙첨")
    @ParameterizedTest(name = "{displayName}{index} -> matchCount: {0}")
    @ValueSource(ints = {0, 1, 2})
    void valueOf_miss(int matchCount) {
        // when
        LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, false);

        // then
        assertThat(lottoPrize).isEqualTo(LottoPrize.MISS);
    }

    @DisplayName("valueOf 유효하지 않은 matchCount 테스트")
    @ParameterizedTest(name = "{displayName}{index} -> matchCount: {0}")
    @ValueSource(ints = {-1, 7})
    void valueOf_invalidMatchCount(int matchCount) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoPrize.valueOf(matchCount, false));
    }
}
