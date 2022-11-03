package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또_프로그램_클래스")
public class GameTest {

    @DisplayName("게임_클래스_생성_정상_케이스")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000"})
    void Game_pass_01(String money) {
        assertThatNoException().isThrownBy(() -> new Game(money));
    }

    @DisplayName("구입금액이_부족할_경우_에러_반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "100"})
    void Game_fail_01(String money) {
        assertThatThrownBy(() -> new Game(money))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또_게임_결과는_게임_수와_동일")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10"})
    public void startLottoGame_pass_01(int count) {
        Game game = new Game(count);
        game.startLottoGame();
        Lottos result = game.startLottoGame();

        assertThat(result.count()).isEqualTo(count);
    }
}