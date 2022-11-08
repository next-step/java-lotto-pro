package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.model.generator.LottoAutoGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또_프로그램_클래스")
public class GameTest {

    @DisplayName("게임_클래스_생성_정상_케이스")
    @Test
    void Game_pass_01() {
        assertThatNoException().isThrownBy(Game::new);
    }

    @DisplayName("게임_클래스_getTotalLottos_정상_케이스")
    @Test
    void Game_getTotalLottos_01() {
        Game game = new Game();
        game.startLottoGame(new LottoAutoGenerator(new LottoBuyCount(3)));
        game.startLottoGame(new LottoAutoGenerator(new LottoBuyCount(3)));
        assertThat(game.getTotalLottos().count()).isEqualTo(6);
    }
}