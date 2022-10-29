package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    List<LottoNumber> candidateLottoNumbers = new ArrayList<>();

    @BeforeEach
    void before() {
        for (int i = 1; i < 46; i++) {
            candidateLottoNumbers.add(new LottoNumber(i));
        }
    }

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


    @DisplayName("로또_게임_결과는_게임_수와_동일")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10"})
    public void getLottoResults_pass_01(int count) {
        Game game = new Game(count);
        List<LottoResult> result = game.getLottoResults();

        assertThat(result.size()).isEqualTo(count);
    }

    @DisplayName("로또_게임_지난_당첨_결과값_정상_파싱_여부")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6"})
    public void setWinLottoNumbers_pass_01(String winLottoNumbers) {
        Game game = new Game();
        game.setWinLottoNumbers(winLottoNumbers);
        assertThat(game.getWinLottoNumbers()).isEqualTo(
                new LottoResult(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
                )
                )
        );
    }

    @DisplayName("로또_게임_지난_당첨_결과값_사이즈_6_보다_작으면_에러")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1", ""})
    public void setWinLottoNumbers_fail_01(String winLottoNumbers) {
        Game game = new Game();
        assertThatThrownBy(() -> game.setWinLottoNumbers(winLottoNumbers))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또_게임_지난_당첨_결과값_파싱후_문자열이면_에러")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", "1a,2, 3, 4, 5, 6"})
    public void setWinLottoNumbers_fail_02(String winLottoNumbers) {
        Game game = new Game();
        assertThatThrownBy(() -> game.setWinLottoNumbers(winLottoNumbers))
                .isInstanceOf(RuntimeException.class);
    }
}
