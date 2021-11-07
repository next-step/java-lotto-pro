package lotto;

import lotto.exception.InvalidInputException;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.common.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("당첨번호 기능 테스트")
public class WinningNumberTests {

    @DisplayName("당첨번호 생성 성공을 테스트합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6", "8, 10, 24,38,44, 45"})
    public void 당첨번호_생성_성공(String inputValues) {
        WinningNumbers winningNumbers = new WinningNumbers(inputValues);

        assertAll(
                () -> assertThat(winningNumbers.getValues()).isInstanceOf(List.class),
                () -> assertThat(winningNumbers.getValues().size()).isEqualTo(GET_NUMBER_COUNT),
                () -> {
                    for (Integer value : winningNumbers.getValues()) {
                        assertThat(value)
                                .isInstanceOf(Integer.class)
                                .isPositive()
                                .isGreaterThanOrEqualTo(MIN_RANGE_VALUE)
                                .isLessThanOrEqualTo(MAX_RANGE_VALUE);
                    }
                }
        );
    }

    @DisplayName("당첨번호 생성 실패를 테스트합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1, 2, 3, 4, 5, 46", "0, 2, 3, 4, 5, 45", "1, 2, 3, 4, 5, 5", "8;10,24,38,44,45"})
    public void 당첨번호_생성_실패(String inputValues) {
        assertThatThrownBy(() -> new WinningNumbers(inputValues)).isInstanceOf(InvalidInputException.class);
    }

}
