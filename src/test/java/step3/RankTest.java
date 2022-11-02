package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Rank;

public class RankTest {

    @Test
    @DisplayName("매치 카운트에 따른 랭크 값을 출력하는 테스트1")
    void rankTest() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:false:FIRST", "5:true:SECOND", "5:false:THIRD","4:false:FOURTH"
        ,"3:false:FIFTH","3:true:FIFTH","2:false:NOTHING", "2:true:NOTHING"}, delimiter = ':')
    @DisplayName("매치 카운트에 따른 랭크 값을 출력하는 테스트2")
    void setTest3(int count, boolean bonus, Rank rank) {
        assertThat(Rank.valueOf(count, bonus)).isEqualTo(rank);
    }

}
