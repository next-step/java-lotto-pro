package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    List<Integer> candidateLottoNumbers = new ArrayList<>();

    @BeforeEach
    void before() {
        for (int i = 1; i < 46; i++) {
            candidateLottoNumbers.add(i);
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
    public void getLottoResult_pass_01(int count) {
        Game game = new Game(count);
        List<List<Integer>> result = game.getLottoResult();

        assertThat(result.size()).isEqualTo(count);
    }

    @DisplayName("로또_게임_결과값은_1과_45_사이의_값")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000"})
    public void getLottoResult_pass_02(String money) {
        Game game = new Game(money);
        List<List<Integer>> result = game.getLottoResult();

        for (List<Integer> lotto : result) {
            assertThat(candidateLottoNumbers).containsAll(lotto);
        }
    }

    @DisplayName("로또_게임_결과값은_숫자_기준으로_정렬되어야_한다")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000"})
    public void getLottoResult_pass_03(String money) {
        Game game = new Game(money);
        List<List<Integer>> result = game.getLottoResult();

        for (List<Integer> lotto : result) {
            List<Integer> beforeData = new ArrayList<>(lotto);
            Collections.sort(lotto);
            assertThat(lotto).isEqualTo(beforeData);
        }
    }

    @DisplayName("로또_게임_결과값은_0미만_46이상은_없어야_한다")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000"})
    public void getLottoResult_fail_01(String money) {
        Game game = new Game(money);
        List<List<Integer>> result = game.getLottoResult();

        for (List<Integer> lotto : result) {
            assertThat(lotto).doesNotContain(0, 46);
        }
    }

}
