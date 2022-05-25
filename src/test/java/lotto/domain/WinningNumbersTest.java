package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    private static Lotto lotto;

    @BeforeAll
    static void beforeAll() {
        lotto = new Lotto("1, 2, 3, 4, 5, 6");
    }

    @Test
    @DisplayName("보너스 중복 Exception 테스트")
    void bonus_duplicate_test() {
        assertThatThrownBy(() -> new WinningNumbers(lotto, LottoNumber.of(6)))
                .isInstanceOf(LottoException.class);
    }

    @Test
    @DisplayName("당첨 번호 생성")
    void bonus_create_test() {
        assertThat(new WinningNumbers(lotto, LottoNumber.of(8)))
                .isInstanceOf(WinningNumbers.class);
    }
}