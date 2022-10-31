package step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또_프로그램_클래스")
public class GameTest {

    List<LottoNumber> candidateLottoNumbers = new ArrayList<>();

    @BeforeEach
    void before() {
        for (int i = 1; i < 46; i++) {
            candidateLottoNumbers.add(new LottoNumber(i));
        }
    }

    @DisplayName("구입금액이_부족할_경우_에러_반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "100"})
    void getLottoCount_fail_03(String money) {
        assertThatThrownBy(() -> new Game(money))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또_게임_결과는_게임_수와_동일")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10"})
    public void getLottoResults_pass_01(int count) {
        Game game = new Game(count);
        game.startLottoGame();
        List<LottoResult> result = game.getLottoResults();

        assertThat(result.size()).isEqualTo(count);
    }
}