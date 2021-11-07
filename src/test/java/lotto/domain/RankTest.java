package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @ParameterizedTest
    @CsvSource(value = "2,false", delimiter = ',')
    @DisplayName("랭크 테스트")
    public void none(int matCount, boolean matchBonus) {
        Rank none = Rank.of(matCount, matchBonus);

        Rank excepted = Rank.NONE;

        assertThat(none).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = "6,false", delimiter = ',')
    @DisplayName("랭크 테스트")
    public void first(int matCount, boolean matchBonus) {
        Rank none = Rank.of(matCount, matchBonus);

        Rank excepted = Rank.FIRST;

        assertThat(none).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = "5,true", delimiter = ',')
    @DisplayName("랭크 테스트")
    public void second(int matCount, boolean matchBonus) {
        Rank none = Rank.of(matCount, matchBonus);

        Rank excepted = Rank.SECOND;

        assertThat(none).isEqualTo(excepted);
    }

}