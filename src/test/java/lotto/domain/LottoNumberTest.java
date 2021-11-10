package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumberTest {

    @DisplayName("로또 번호 인스턴스 생성 성공 테스트")
    @ParameterizedTest(name = "{displayName}{index} -> number: {0}")
    @ValueSource(ints = {0, 46})
    void instantiate_success(int number) {
        // when & then
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> new LottoNumber(number))
                .withMessage(LottoNumber.LOTTO_NUMBER_RANGE_ERROR);
    }

    @DisplayName("로또 번호 인스턴스 생성 실패 테스트")
    @ParameterizedTest(name = "{displayName}{index} -> number: {0}")
    @ValueSource(ints = {1, 45})
    void instantiate_failure(int number) {
        // when
        LottoNumber lottoNumber = new LottoNumber(number);

        // then
        assertThat(lottoNumber)
                .isExactlyInstanceOf(LottoNumber.class);
    }

    @DisplayName("isBonusNumber true 테스트")
    @Test
    void isBonusNumber_true() {
        // given
        int number = 1;
        int bonusNumber = 1;

        // when
        LottoNumber lottoNumber = new LottoNumber(number);
        BonusLottoNumber bonusLottoNumber = new BonusLottoNumber(bonusNumber);
        boolean result = lottoNumber.isBonusNumber(bonusLottoNumber);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("isBonusNumber false 테스트")
    @Test
    void isBonusNumber_false() {
        // given
        int number = 1;
        int bonusNumber = 2;

        // when
        LottoNumber lottoNumber = new LottoNumber(number);
        BonusLottoNumber bonusLottoNumber = new BonusLottoNumber(bonusNumber);
        boolean result = lottoNumber.isBonusNumber(bonusLottoNumber);

        // then
        assertThat(result).isFalse();
    }
}
