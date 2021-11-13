package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningLottoTest {

    private int[] numbers;

    @BeforeEach
    void setUp() {
        numbers = new int[]{1, 2, 3, 4, 5, 6};
    }

    @DisplayName("WinningLotto 인스턴스 생성 성공 테스트")
    @Test
    void instantiate_success() {
        // given
        int bonusNumber = 7;

        // when
        WinningLotto winningLotto = new WinningLotto(bonusNumber, numbers);

        // then
        assertThat(winningLotto).isExactlyInstanceOf(WinningLotto.class);
    }

    @DisplayName("WinningLotto 인스턴스 생성 실패 테스트")
    @Test
    void instantiate_failure() {
        // given
        int bonusNumber = 6;

        // when & then
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> new WinningLotto(bonusNumber, numbers))
                .withMessage(WinningLotto.BONUS_NUMBER_ERROR);
    }

    @DisplayName("checkMatchBonus true 테스트")
    @Test
    void checkMatchBonus_true() {
        // given
        int bonusNumber = 7;

        // when
        WinningLotto winningLotto = new WinningLotto(bonusNumber, numbers);
        boolean result = winningLotto.checkMatchBonus(new Lotto(1, 2, 3, 4, 5, 7));

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("checkMatchBonus false 테스트")
    @Test
    void checkMatchBonus_false() {
        // given
        int bonusNumber = 7;

        // when
        WinningLotto winningLotto = new WinningLotto(bonusNumber, numbers);
        boolean result = winningLotto.checkMatchBonus(new Lotto(1, 2, 3, 4, 5, 6));

        // then
        assertThat(result).isFalse();
    }
}
