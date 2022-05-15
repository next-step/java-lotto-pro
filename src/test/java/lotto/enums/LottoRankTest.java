package lotto.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6:FIRST:false", "5:SECOND:true", "5:THIRD:false", "4:FOURTH:false", "3:FIFTH:false",
            "0:MISS:false"}, delimiter = ':')
    void 로또_등수_가져오기(int input, LottoRank expected, boolean matchBonus) {
        LottoRank lottoRank = LottoRank.valueOf(input, matchBonus);
        Assertions.assertThat(lottoRank).isEqualTo(expected);
    }
}
