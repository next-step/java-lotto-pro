package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static lotto.domain.ExceptionMessage.ILLEGAL_SIZE;
import static lotto.domain.ExceptionMessage.NUMBER_DUPLICATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @Test
    void 생성_예외_개수() {
        assertThatThrownBy(() -> new LottoGame(Arrays.asList(1, 2, 5, 25, 30, 42, 44)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_SIZE.getMessage());
    }

    @Test
    void 생성_예외_중복() {
        assertThatThrownBy(() -> new LottoGame(Arrays.asList(1, 2, 25, 25, 30, 42)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_DUPLICATE.getMessage());
    }

    @ParameterizedTest
    @CsvSource(
            value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,10:THIRD", "1,2,3,4,10,11:FOURTH", "1,2,3,10,11,12:FIFTH"},
            delimiter = ':')
    void 당첨(String winningNumbers, String rank) {
        LottoGame lottoGame = new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 6));

        Rank result = lottoGame.check(new WinningNumbers(winningNumbers), new LottoNumber(45));

        assertThat(result).isEqualTo(Rank.valueOf(rank));
    }

    @Test
    void 당첨_보너스() {
        LottoGame lottoGame = new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 6));

        Rank rank = lottoGame.check(new WinningNumbers("1,2,3,4,5,10"), new LottoNumber("6"));

        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
