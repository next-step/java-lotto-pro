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
            "0,MISS",
            "1,MISS",
            "2,MISS",
            "3,THREE_MATCH",
            "4,FOUR_MATCH",
            "5,FIVE_MATCH",
            "6,SIX_MATCH"
    })
    void valueOf(int matchCount, LottoPrize lottoPrize) {
        assertThat(LottoPrize.valueOf(matchCount)).isEqualTo(lottoPrize);
    }

    @DisplayName("MISS를 제외한 LottoPrize 리스트 반환")
    @Test
    void exclusiveMiss() {
        assertThat(LottoPrize.exclusiveMiss()).doesNotContain(LottoPrize.MISS);
    }
}
