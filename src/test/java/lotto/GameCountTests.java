package lotto;

import lotto.exception.UnexpectValueException;
import lotto.model.GameCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.common.Constants.GAME_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("게임횟수 기능 테스트")
public class GameCountTests {

    private static final String MESSAGE = "[ERROR]오류가 발생했습니다.";

    @DisplayName("실행할 게임횟수 생성을 테스트합니다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 3240, 12300})
    public void 게임횟수_생성(int purchaseAmount) {
        GameCount gameCount = new GameCount(purchaseAmount);
        assertThat(gameCount.getValue()).isEqualTo(purchaseAmount / GAME_PRICE);
    }

    @DisplayName("실행할 게임횟수 생성 실패를 테스트합니다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 990})
    public void 게임횟수_생성_실패(int purchaseAmount) {
        assertThatThrownBy(() -> new GameCount(purchaseAmount))
                .isInstanceOf(UnexpectValueException.class)
                .hasMessageContaining(MESSAGE);
    }

}
