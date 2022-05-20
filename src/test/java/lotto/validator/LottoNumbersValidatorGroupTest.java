package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.validator.LottoNumbersValidatorGroup;
import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨번호 validator group 에 대한 테스트")
class LottoNumbersValidatorGroupTest {
    private final LottoNumbersValidatorGroup lottoNumbersValidatorGroup = LottoNumbersValidatorGroup.getInstance();

    @DisplayName("싱글톤 테스트 - 싱글톤 객체는 여러번 생성해도 같은 객체이어야 한다")
    @Test
    void singleton_test() {
        LottoNumbersValidatorGroup validatorGroup = LottoNumbersValidatorGroup.getInstance();
        LottoNumbersValidatorGroup validatorGroup_2 = LottoNumbersValidatorGroup.getInstance();
        LottoNumbersValidatorGroup validatorGroup_3 = LottoNumbersValidatorGroup.getInstance();

        assertEquals(validatorGroup, validatorGroup_2);
        assertEquals(validatorGroup, validatorGroup_3);
        assertEquals(validatorGroup_2, validatorGroup_3);
    }

    @DisplayName("잘못된 포맷인 데이터를 전달하면 포맷에 대한 에러메시지가 나와야 한다")
    @Test
    void validator_exception_test() {
        String given = "1,3,5,11,13,15,";

        assertThatThrownBy(() -> {
            lottoNumbersValidatorGroup.validate(given);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_LOTTO_NUMBER_FORMAT.getMessage());
    }

    @DisplayName("1-45 이외의 데이터를 전달하면 당첨번호 크기에 대한 에러메시지가 나와야 한다")
    @Test
    void validator_exception_test2() {
        String given = "1,3,42,56,13,15";

        assertThatThrownBy(() -> {
            lottoNumbersValidatorGroup.validate(given);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
    }

    @DisplayName("중복딘 당첨번호가 존재하면 중복에 대한 에러메시지가 나와야 한다")
    @Test
    void validator_exception_test3() {
        String given = "1,3,5,13,13,42";

        assertThatThrownBy(() -> {
            lottoNumbersValidatorGroup.validate(given);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.IS_NOT_OVERLAP_WINNING_NUMBER.getMessage());
    }
}
