package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRankTest {

    @ParameterizedTest
    @CsvSource(value = {
            "6,false,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,true,FOURTH",
            "4,false,FOURTH",
            "3,true,FIFTH",
            "3,false,FIFTH",
            "2,true,NONE",
            "2,false,NONE",
            "1,true,NONE",
            "1,false,NONE",
            "0,true,NONE",
            "0,false,NONE"
    })
    void 당첨결과를_도출해_낼_수_있다(Integer matchCount, Boolean matchBonus, String stringWinningRank) {
        WinningRank expected = WinningRank.valueOf(stringWinningRank);
        assertThat(WinningRank.of(matchCount, matchBonus)).isEqualTo(expected);
    }
}