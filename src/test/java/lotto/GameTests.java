package lotto;

import lotto.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static lotto.common.Constants.*;

@DisplayName("게임 기능 테스트")
public class GameTests {

    private Game game;

    @BeforeEach
    public void 게임_초기화() {
        game = new Game();
    }

    @DisplayName("난수 생성 기능을 테스트합니다.")
    @Test
    public void 난수생성() {
        List<Integer> list = game.getNumbers();
        assertAll(
                () -> assertThat(list)
                        .isNotEmpty()
                        .isInstanceOf(List.class),
                () -> assertThat(list.size()).isEqualTo(GET_NUMBER_COUNT)
        );
    }

    @DisplayName("생성된 난수가 옳바른 숫자로 구성되었는지 확인합니다.")
    @Test
    public void 생성된_난수_유효성검사() {
        assertAll(
                () -> {
                    for (Integer number : game.getNumbers()) {
                        assertThat(number)
                                .isInstanceOf(Integer.class)
                                .isPositive()
                                .isGreaterThanOrEqualTo(MIN_RANGE_VALUE)
                                .isLessThanOrEqualTo(MAX_RANGE_VALUE);
                    }
                }
        );
    }

}
