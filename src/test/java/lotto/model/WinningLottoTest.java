package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6), 7);
    }

    @Test
    void createWinningLotto_보너스번호_중복_예외발생() {
        assertThatThrownBy(() -> new WinningLotto(Arrays.asList(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void findEarningsRate() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(23, 25, 33, 36, 39, 41)),
                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)),
                new Lotto(Arrays.asList(5, 9, 38, 41, 43, 44)),
                new Lotto(Arrays.asList(2, 8, 9, 18, 19, 21)),
                new Lotto(Arrays.asList(13, 14, 18, 21, 23, 35)),
                new Lotto(Arrays.asList(17, 21, 29, 37, 42, 45)),
                new Lotto(Arrays.asList(3, 8, 27, 30, 35, 44))
        ));

        WinningStatus winningStatus = lottos.compareLottos(winningLotto);

        assertThat(winningStatus.findEarningsRate(new PurchasePrice(14000))).isEqualTo(0.35);
    }

    @Test
    void compareMatchPointCount() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,8,9), 10);

        assertThat(winningLotto.compareMatchPointCount(lotto)).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:true", "10:false"}, delimiter = ':')
    void isMatchBonus(int bonusBall, boolean result) {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        assertThat(new WinningLotto(Arrays.asList(1,2,3,4,8,9), bonusBall).isMatchBonus(lotto)).isEqualTo(result);
    }
}
