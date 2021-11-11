package lotto;

import lotto.exception.UnexpectValueException;
import lotto.model.GameCount;
import lotto.model.ManualGameCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("수동게임횟수 기능 테스트")
public class ManualGameCountTests {

    private static final String MESSAGE = "[ERROR]오류가 발생했습니다.";

    @DisplayName("실행할 수동게임횟수 생성을 테스트합니다.")
    @ParameterizedTest
    @CsvSource(value = {"3000;3", "5000;2", "5000;0"}, delimiterString = ";")
    public void 수동게임횟수_생성(int purchaseAmount, int inputManualGameCount) {
        GameCount gameCount = new GameCount(purchaseAmount);
        ManualGameCount manualGameCount = new ManualGameCount(gameCount.getValue(), inputManualGameCount);

        assertThat(manualGameCount.getValue())
                .isInstanceOf(Integer.class)
                .isEqualTo(inputManualGameCount);
    }

    @DisplayName("실행할 수동게임횟수 생성 실패를 테스트합니다.")
    @ParameterizedTest
    @CsvSource(value = {"3000;5", "5000;10"}, delimiterString = ";")
    public void 수동게임횟수_생성_실패(int purchaseAmount, int inputManualGameCount) {
        GameCount gameCount = new GameCount(purchaseAmount);
        assertThatThrownBy(() -> new ManualGameCount(gameCount.getValue(), inputManualGameCount))
                .isInstanceOf(UnexpectValueException.class)
                .hasMessageContaining(MESSAGE);
    }

}
