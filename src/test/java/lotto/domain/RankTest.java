package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("Lotto, 기준 Lotto 와 match 되는 숫자에 따른 Reward Type 반환")
    public void Rank_match_Type() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 10, 6, 34, 45));
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 20, 30, 40, 34, 45));
        Lotto lotto = new Lotto(numbers);
        Lotto winLotto = new Lotto(winNumbers);
        assertThat(Rank.match(lotto, winLotto)).isEqualTo(Rank.FOURTH);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:FIRST","5:THIRD","4:FOURTH","3:FIFTH","0:MISS"}, delimiter = ':')
    @DisplayName("match 숫자에 따른 Rank 반환_no_bonus")
    void Rank_Match_Num_No_Bonus(int rankValue, Rank result) {
        assertThat(Rank.valueOf(rankValue,false)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:SECOND"}, delimiter = ':')
    @DisplayName("match 숫자에 따른 Rank 반환_bonus")
    void Rank_Match_Num_Bonus(int rankValue, Rank result) {
        assertThat(Rank.valueOf(rankValue,true)).isEqualTo(result);
    }

}
