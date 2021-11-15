package lotto.domain;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @DisplayName("로또 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"3,false,FIFTH", "4,false,FOURTH", "5,false,THIRD", "5,true,SECOND", "6,false,FIRST",
        "0,false,MISS", "2,false,MISS", "4,true,FOURTH"})
    void valueOf(int cnt, boolean containsBonus, String rankName) {
        assertThat(Rank.valueOf(cnt, containsBonus)).isEqualTo(Rank.valueOf(rankName));
    }

    @DisplayName("상금이 있는 등수만 가져옴")
    @Test
    void winningValues() {
        assertThat(Rank.winningValues())
            .isEqualTo(Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST));
    }

    @DisplayName("2등인지 확인")
    @Test
    void isSecond_true() {
        assertThat(Rank.isSecond(SECOND)).isEqualTo(true);
    }

    @DisplayName("2등이 아닌 경우 확인")
    @ParameterizedTest
    @ValueSource(strings = {"MISS", "FIFTH", "FOURTH", "THIRD", "FIRST"})
    void isSecond_false(String rankName) {
        assertThat(Rank.isSecond(Rank.valueOf(rankName))).isEqualTo(false);
    }
}