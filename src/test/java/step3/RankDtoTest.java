package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Rank;
import step3.model.dto.RankDto;

import static org.assertj.core.api.Assertions.assertThat;

public class RankDtoTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    @DisplayName("맞춘번호가 3개 이상경우 true를 반환")
    void test_that_it_returns_true_when_match_number_greater_than_3(int matchCount) {

        //given,when
        RankDto rankDto = new RankDto(Rank.valueOf((countParam, bonusParam) -> countParam == matchCount && bonusParam), 1);

        //then
        assertThat(rankDto.isWin()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("맞춘번호가 3개 미만경우 false를 반환")
    void test_that_it_returns_true_when_match_number_less_than_3(int matchCount) {

        //given,when
        RankDto rankDto = new RankDto(Rank.valueOf((countParam, bonusParam) -> countParam == matchCount && bonusParam), 1);

        //then
        assertThat(rankDto.isWin()).isFalse();
    }

}
