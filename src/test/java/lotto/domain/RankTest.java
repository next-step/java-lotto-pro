package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"6:FIRST","5:THIRD","4:FOURTH","3:FIFTH","0:MISS"}, delimiter = ':')
    @DisplayName("match 숫자에 따른 Rank 반환_no_bonus")
    void Rank_Match_Num_No_Bonus(int rankValue, Rank result) {
        assertThat(Rank.valueOf(rankValue,false)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:FIRST","5:SECOND","4:FOURTH","3:FIFTH","0:MISS"}, delimiter = ':')
    @DisplayName("match 숫자에 따른 Rank 반환_bonus")
    void Rank_Match_Num_Bonus(int rankValue, Rank result) {
        assertThat(Rank.valueOf(rankValue, true)).isEqualTo(result);
    }

}
