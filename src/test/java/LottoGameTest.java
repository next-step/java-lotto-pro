import lotto.LottoGame;
import lotto.LottoNumber;
import lotto.Match;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @Test
    void 생성_예외_개수() {
        assertThatThrownBy(() -> {
            new LottoGame(Arrays.asList(1, 2, 5, 25, 30, 42, 44));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoGame.ILLEGAL_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    void 생성_예외_중복() {
        assertThatThrownBy(() -> {
            new LottoGame(Arrays.asList(1, 2, 25, 25, 30, 42));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoGame.NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 22, 40})
    void 번호_일치(int input) {
        LottoGame lottoGame = new LottoGame(Arrays.asList(1, 2, 3, 10, 22, 40));

        boolean result = lottoGame.has(new LottoNumber(input));

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 7, 20, 45})
    void 번호_불일치(int input) {
        LottoGame lottoGame = new LottoGame(Arrays.asList(1, 2, 3, 10, 22, 40));

        boolean result = lottoGame.has(new LottoNumber(input));

        assertThat(result).isFalse();
    }

    @Test
    void 당첨_번호_일치_개수() {
        LottoGame lottoGame = new LottoGame(Arrays.asList(1, 2, 3, 10, 22, 40));

        Match result = lottoGame.check(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(3),
                new LottoNumber(5),
                new LottoNumber(14),
                new LottoNumber(22),
                new LottoNumber(44)));

        assertThat(result).isEqualTo(new Match(3));
    }
}
