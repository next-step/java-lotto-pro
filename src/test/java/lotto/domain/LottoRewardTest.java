package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRewardTest {

    @ParameterizedTest
    @CsvSource(value = {"6:false:FIRST_PLACE", "5:true:SECOND_PLACE", "5:false:THIRD_PLACE", "2:false:MISS"}, delimiter = ':')
    void 로또_보상_Enum_값_조회(int matchCount, boolean matchBonus, LottoReward lottoReward) {
        // when
        LottoReward result = LottoReward.getLottoReward(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(lottoReward);
    }
}