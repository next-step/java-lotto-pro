package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoPrize 클래스 테스트")
public class LottoPrizeTest {

    @DisplayName("맞춘 갯수에 따른 LottoPrize 반환")
    @ParameterizedTest
    @CsvSource({
            "MISS, 0, false",
            "MISS, 1, false",
            "MISS, 2, false",
            "THREE_MATCH, 3,false",
            "FOUR_MATCH, 4, false",
            "FIVE_MATCH, 5, false",
            "FIVE_MATCH_WITH_BONUS, 5, true",
            "SIX_MATCH,6, false"
    })
    void valueOf(LottoPrize lottoPrize, int matchCount, boolean matchBonus) {
        assertThat(LottoPrize.valueOf(matchCount, matchBonus)).isEqualTo(lottoPrize);
    }

    @DisplayName("MISS를 제외한 LottoPrize 리스트 반환")
    @Test
    void exclusiveMiss() {
        assertThat(LottoPrize.exclusiveMiss()).doesNotContain(LottoPrize.MISS);
    }
}
