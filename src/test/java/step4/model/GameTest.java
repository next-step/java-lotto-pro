package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.generator.LottoAutoGenerator;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또_프로그램_클래스")
public class GameTest {

    @DisplayName("게임_클래스_생성_정상_케이스")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000"})
    void Game_pass_01(String money) {
        assertThatNoException().isThrownBy(() -> new Game(money));
    }

    @DisplayName("게임_클래스_생성_정상_케이스_02")
    @ParameterizedTest
    @CsvSource(value = {"1000:1:0", "10000:9:1"}, delimiter = ':')
    public void Game_pass_02(int money, int manualCount, int autoCount) {
        Game game = new Game(new Money(money), new LottoBuyCount(manualCount));

        assertThat(game.getLottoAutoBuyCount(new LottoBuyCount(manualCount))).isEqualTo(new LottoBuyCount(autoCount));
    }

    @DisplayName("게임_클래스_수동_구입_개수가_총_살수있는_개수보다_클경우_에러반환")
    @ParameterizedTest
    @CsvSource(value = {"1000:2", "10000:11"}, delimiter = ':')
    public void Game_fail_03(int money, int manualCount) {
        assertThatThrownBy(() -> new Game(new Money(money), new LottoBuyCount(manualCount)))
                .isInstanceOf(RuntimeException.class);
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
        Lottos result = game.startLottoGame(new LottoAutoGenerator(count));

        assertThat(result.count()).isEqualTo(count);
    }

    @DisplayName("로또_게임_Auto_Buy_Count_확인")
    @ParameterizedTest
    @CsvSource(value = {"1000:1:0", "10000:9:1"}, delimiter = ':')
    public void startLottoGame_pass_01(int money, int manualCount, int autoCount) {
        Game game = new Game(new Money(money), new LottoBuyCount(manualCount));

        assertThat(game.getLottoAutoBuyCount(new LottoBuyCount(manualCount))).isEqualTo(new LottoBuyCount(autoCount));
    }

}