package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.RankFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class RankFuctionTest {

    @Test
    @DisplayName("매칭개수가 6개를 만족하면 true반환")
    void test_that_returns_true_when_matched_1(){
        //given
        RankFunction rankFunction = new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch == 6,6);

        //when
        boolean isMatch = rankFunction.isMatch(6,false);

        //then
        assertThat(isMatch).isTrue();
    }

    @Test
    @DisplayName("매칭개수가 5개와 보너스를 만족하면 true반환")
    void test_that_returns_true_when_matched_5_and_bonus(){
        //given
        RankFunction rankFunction = new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch == 5 && isMatchBonus,5);

        //when
        boolean isMatch = rankFunction.isMatch(5,true);

        //then
        assertThat(isMatch).isTrue();
    }

    @Test
    @DisplayName("매칭개수가 5개를 만족하면 true반환")
    void test_that_returns_true_when_matched_5(){
        //given
        RankFunction rankFunction = new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch == 5 && !isMatchBonus,5);

        //when
        boolean isMatch = rankFunction.isMatch(5,false);

        //then
        assertThat(isMatch).isTrue();
    }

    @Test
    @DisplayName("매칭개수가 4개를 만족하면 true반환")
    void test_that_returns_true_when_matched_4(){
        //given
        RankFunction rankFunction = new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch == 4,4);

        //when
        boolean isMatch = rankFunction.isMatch(4,false);

        //then
        assertThat(isMatch).isTrue();
    }

    @Test
    @DisplayName("매칭개수가 3개를 만족하면 true반환")
    void test_that_returns_true_when_matched_3(){
        //given
        RankFunction rankFunction = new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch == 3,3);

        //when
        boolean isMatch = rankFunction.isMatch(3,false);

        //then
        assertThat(isMatch).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    @DisplayName("매칭개수가 3개미만을 만족하면 true반환")
    void test_that_returns_true_when_matched_less_then_3(int matchCount){
        //given
        RankFunction rankFunction = new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch < 3,3);

        //when
        boolean isMatch = rankFunction.isMatch(matchCount,false);

        //then
        assertThat(isMatch).isTrue();
    }


}
