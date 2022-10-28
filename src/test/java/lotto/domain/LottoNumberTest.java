package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    void 로또번호_생성하기() {
        assertThatThrownBy(() -> new LottoNumber(null))
            .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> new LottoNumber(Arrays.asList(1, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 50)))
            .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, -1)))
            .isInstanceOf(IllegalStateException.class);
        assertDoesNotThrow(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 당첨번호와_일치하는_개수_구하기() {
        assertThat(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))
            .calculateWinPrize(new LottoNumber(Arrays.asList(7, 8, 9, 10, 11, 12)))).isEqualTo(Prize.NOTHING);
        assertThat(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))
            .calculateWinPrize(new LottoNumber(Arrays.asList(1, 7, 8, 9, 10, 11)))).isEqualTo(Prize.NOTHING);
        assertThat(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))
            .calculateWinPrize(new LottoNumber(Arrays.asList(1, 2, 7, 8, 9, 10)))).isEqualTo(Prize.NOTHING);
        assertThat(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))
            .calculateWinPrize(new LottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)))).isEqualTo(Prize.FOURTH);
        assertThat(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))
            .calculateWinPrize(new LottoNumber(Arrays.asList(1, 2, 3, 4, 8, 9)))).isEqualTo(Prize.THIRD);
        assertThat(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))
            .calculateWinPrize(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 9)))).isEqualTo(Prize.SECOND);
        assertThat(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))
            .calculateWinPrize(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(Prize.FIRST);
    }
}