package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import lotto.constants.LottoErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Test
    @DisplayName("리스트 형식의 로또 번호를 입력받을 때 값이 동일한지 검증")
    void inputLottoNumberList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoNumber lottoNumber = new LottoNumber(list);

        Assertions.assertEquals(lottoNumber, new LottoNumber(list));
    }

    @ParameterizedTest(name = "잘못된 문자열({0}) 로또 번호를 입력받을 때 IllegalArgumentException가 발생")
    @ValueSource(strings = {"1,2,3,4,5", "5, 8, 10, 12, 16, 18, 20", "1, 2, 3, 4, 5, a"})
    void inputInvalidLottoNumberString(String invalidLottoNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(invalidLottoNumber))
                .withMessage(LottoErrorMessage.INVALID_LOTTO_NUMBER_FORMAT);
    }

    @Test
    @DisplayName("로또 번호를 벗어난 값을 입력받을 때 IllegalArgumentException가 발생")
    void inputOutOfRangeLottoNumberString() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber("1, 2, 3, 4, 5, 100"))
                .withMessage(LottoErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER);
    }
}
