package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningLottoNumberTest {

    @Test
    void 당첨번호를_생성할_수_있다() {
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        assertThat(winningLottoNumber.getNumbers()).isEqualTo(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(winningLottoNumber.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void 당첨번호는_중복되는_숫자가_될_수_없다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 5), 7));
    }

    @Test
    void 보너스번호도_당첨번호와_중복될_수_없다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 6));
    }

    @Test
    void 당첨번호는_1부터_45_사이의_숫자만_가능하다() {
        new WinningLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 45), 7);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 46), 7));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLottoNumber(Arrays.asList(0, 2, 3, 4, 5, 6), 7));
    }

    @Test
    void 보너스번호는_1부터_45_사이의_숫자만_가능하다() {
        new WinningLottoNumber(Arrays.asList(2, 3, 4, 5, 6, 7), 1);
        new WinningLottoNumber(Arrays.asList(2, 3, 4, 5, 6, 7), 45);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 46));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 0));
    }

}