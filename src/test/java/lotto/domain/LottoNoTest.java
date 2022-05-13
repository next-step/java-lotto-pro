package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoConstant.LOTTO_END_NUMBER;
import static lotto.domain.LottoConstant.LOTTO_START_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNoTest {
    @Test
    public void 문제없는_로또_번호() {
        new LottoNo(LOTTO_START_NUMBER);
        new LottoNo((LOTTO_START_NUMBER + LOTTO_END_NUMBER) / 2);
        new LottoNo(LOTTO_END_NUMBER);
    }

    @Test
    public void 문자열_생성자_로또_생성() {
        new LottoNo(String.valueOf(LOTTO_START_NUMBER));
        new LottoNo(String.valueOf(LOTTO_END_NUMBER));
    }

    @Test
    public void 문제있는_로또_번호() {
        assertThatThrownBy(() -> {
            new LottoNo(LOTTO_START_NUMBER - 1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new LottoNo(LOTTO_END_NUMBER + 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
