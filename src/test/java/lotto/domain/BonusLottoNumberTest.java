package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BonusLottoNumberTest {

    @DisplayName("BonusLottoNumber 인스턴스 생성 성공 테스트")
    @Test
    void instantiate_success() {
        // given
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        int bonusNumber = 7;

        // when
        BonusLottoNumber bonusLottoNumber = new BonusLottoNumber(bonusNumber, numbers);

        // then
        assertThat(bonusLottoNumber).isEqualTo(new BonusLottoNumber(bonusNumber, numbers));
    }

    @DisplayName("BonusLottoNumber 인스턴스 생성 실패 테스트")
    @Test
    void instantiate_failure() {
        // given
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        int bonusNumber = 6;

        // when & then
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> new BonusLottoNumber(bonusNumber, numbers))
                .withMessage(BonusLottoNumber.BONUS_NUMBER_ERROR);
    }
}
