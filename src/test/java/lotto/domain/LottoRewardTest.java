package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRewardTest {

    @ParameterizedTest
    @CsvSource(value = {"3:true", "6:true", "2:false"}, delimiter = ':')
    void isWinning(int inputNumber, boolean expectResult) {
        // when
        boolean result = LottoReward.isWinning(inputNumber);

        // then
        assertThat(result).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:false:FIRST_PLACE", "5:true:SECOND_PLACE", "5:false:THIRD_PLACE", "2:false:MISS"}, delimiter = ':')
    void getLottoReward(int matchCount, boolean matchBonus, LottoReward lottoReward) {
        // when
        LottoReward result = LottoReward.getLottoReward(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(lottoReward);
    }
}