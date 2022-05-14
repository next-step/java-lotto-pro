package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호를 입력받을 때 값이 동일한지 검증")
    void inputLottoNumberList() {
        List<Number> numberList = Arrays.asList(
                Number.of(1), Number.of(2), Number.of(3),
                Number.of(4), Number.of(5), Number.of(6)
        );
        LottoNumber lottoNumber = new LottoNumber(numberList);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(numberList));
    }

    @Test
    @DisplayName("로또 번호를 중복된 값을 입력받을 때 IllegalArgumentException가 발생")
    void inputDuplicateLottoNumberString() {
        List<Number> duplicateNumberList = Arrays.asList(
                Number.of(1), Number.of(2), Number.of(3),
                Number.of(4), Number.of(1), Number.of(6)
        );
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(duplicateNumberList))
                .withMessage("로또 숫자의 중복은 허용되지 않습니다.");
    }

    @Test
    @DisplayName("일치하는 번호 갯수를 반환하는지 검증")
    void verifyCountMatchLottoNumber() {
        List<Number> pickNumber = Arrays.asList(
                Number.of(1), Number.of(2), Number.of(3),
                Number.of(4), Number.of(5), Number.of(6)
        );
        List<Number> winningNumber = Arrays.asList(
                Number.of(1), Number.of(2), Number.of(3),
                Number.of(7), Number.of(8), Number.of(9)
        );
        LottoNumber pickLottoNumber = new LottoNumber(pickNumber);
        LottoNumber winningLottoNumber = new LottoNumber(winningNumber);

        assertEquals(3, pickLottoNumber.countMatchLottoNumber(winningLottoNumber));
    }

    @Test
    @DisplayName("입력받은 수가 로또 번호에 있는지 검증")
    void verifyContainNumber() {
        LottoNumber lottoNumber = new LottoNumber(
                Arrays.asList(
                        Number.of(1), Number.of(2), Number.of(3),
                        Number.of(7), Number.of(8), Number.of(9)
                )
        );

        assertThat(lottoNumber.isContainNumber(Number.of(3))).isTrue();
    }
}
