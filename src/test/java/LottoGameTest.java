import lotto.domain.LottoGame;
import lotto.domain.LottoNumberBounds;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @Test
    void test() {
        int value = LottoNumberBounds.MIN.getValue();
        System.out.println("value = " + value);
    }

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

    @Test
    void 당첨_번호_일치_개수() {
        LottoGame lottoGame = new LottoGame(Arrays.asList(1, 2, 3, 10, 22, 40));

        Rank result = lottoGame.check(new WinningNumbers("1,2,3, 4,5, 6"));

        assertThat(result).isEqualTo(Rank.FIFTH);
    }
}
