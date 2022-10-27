package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
    @DisplayName("입력된_금액에_맞추어_로또_구매_개수_조회")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10", "0:0"}, delimiter = ':')
    void getLottoCount_pass_01(String money, int count) {
        Game game = new Game(money);
        assertThat(game.getLottoBuyCount()).isEqualTo(count);

    }

    @DisplayName("입력된_값이_숫자가_아니면_에러반환")
    @ParameterizedTest
    @ValueSource(strings = {",:1", "1:0", "a10e"})
    public void getLottoCount_fail_01(String money) {
        assertThatThrownBy(() -> new Game(money))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("숫자로_입력된_값이_음수면_에러반환")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100"})
    public void getLottoCount_fail_02(String money) {
        assertThatThrownBy(() -> new Game(money))
                .isInstanceOf(NumberFormatException.class);
    }
}
