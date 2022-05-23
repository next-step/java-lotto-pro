package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @Test
    @DisplayName("보너스 중복 Exception 테스트")
    void bonus_duplicate_test() {
        assertThatThrownBy(() -> new WinningNumbers(new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3)
                , LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))), LottoNumber.of(6)))
                .isInstanceOf(LottoException.class);
    }

    @Test
    @DisplayName("보너스 당첨 테스트")
    void bonus_test() {
        Lotto lotto = new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(8)));

        assertThat(new WinningNumbers(new Lotto(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))), LottoNumber.of(8)).bonus(lotto))
                .isTrue();
    }
}