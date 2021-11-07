package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("WinningLotto 테스트")
class WinningLottoTest {

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {
            "1:2:3:4:5:6:45:FIRST", "1:2:3:4:5:10:6:SECOND", "1:2:3:4:5:10:45:THIRD",
            "1:2:3:4:9:10:45:FOURTH", "1:2:3:8:9:10:45:FIFTH", "1:2:7:8:9:10:45:NOT_MATCHED"
    }, delimiter = ':')
    @DisplayName("당첨 결과를 반환한다.")
    void getWinningResult(int number1, int number2, int number3, int number4, int number5, int number6, int bonusNumber,
                          WinningResult expected) {
        // given
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(Arrays.asList(number1, number2, number3, number4, number5, number6)),
                new LottoNumber(bonusNumber)
        );

        // when
        WinningResult winningResult = winningLotto.getWinningResult(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // then
        assertThat(winningResult).isEqualTo(expected);
    }
}
