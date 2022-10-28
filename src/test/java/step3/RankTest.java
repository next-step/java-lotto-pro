package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    @DisplayName("valueOf값이 2이하면 MISS 반환")
    void test_that_it_returns_rank_at_match_count_less_than_2(int count) {
        //then
        assertThat(Rank.valueOf(count)).isEqualTo(Rank.MISS);
    }

    @Test
    @DisplayName("valueOf값이 3이면 FIFTH 반환")
    void test_that_it_returns_rank_at_match_count_3() {
        //then
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("valueOf값이 4이면 FOURTH 반환")
    void test_that_it_returns_rank_at_match_count_4() {
        //then
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("valueOf값이 5이면 THIRD 반환")
    void test_that_it_returns_rank_at_match_count_5() {
        //then
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.THIRD);
    }
    @Test
    @DisplayName("valueOf값이 6이면 FIRST 반환")
    void test_that_it_returns_rank_at_match_count_6() {
        //then
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
    }
}
