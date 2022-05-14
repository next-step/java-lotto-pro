package lotto.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6:FIRST", "5:SECOND", "4:THIRD", "3:FOURTH", "0:MISS"}, delimiter = ':')
    void 로또_등수_가져오기(int input, LottoRank expected) {
        LottoRank lottoRank = LottoRank.valueOf(input);
        Assertions.assertThat(lottoRank).isEqualTo(expected);
    }
}
