package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("WinningResult 테스트")
class WinningResultTest {

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {
            "6:true:FIRST", "6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:true:FOURTH",
            "4:false:FOURTH", "3:true:FIFTH", "3:false:FIFTH", "2:true:NOT_MATCHED", "2:false:NOT_MATCHED",
    }, delimiter = ':')
    @DisplayName("당첨 조건에 맞는 당첨 결과를 반환한다.")
    void of(int count, boolean bonusNumberMatched, WinningResult expected) {
        // when
        WinningResult winningResult = WinningResult.of(count, bonusNumberMatched);

        // then
        assertThat(winningResult).isEqualTo(expected);
    }
}
