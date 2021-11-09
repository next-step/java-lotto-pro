package lotto.domain;

import org.junit.jupiter.api.Test;
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

    @Test
    void getLottoReward() {
        // given
        int input1 = 3;
        int input2 = 2;

        // when
        LottoReward result1 = LottoReward.getLottoReward(input1);
        LottoReward result2 = LottoReward.getLottoReward(input2);

        // then
        assertThat(result1).isEqualTo(LottoReward.FOURTH_PLACE);
        assertThat(result2).isEqualTo(null);
    }
}