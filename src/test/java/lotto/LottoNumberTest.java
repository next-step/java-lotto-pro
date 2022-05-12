package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.constants.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Test
    @DisplayName("리스트 형식의 로또 번호를 입력받을 때 값이 동일한지 검증")
    void inputLottoNumberList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoNumber lottoNumber = new LottoNumber(list);

        assertEquals(lottoNumber, new LottoNumber(list));
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

    @Test
    @DisplayName("로또 번호를 중복된 값을 입력받을 때 IllegalArgumentException가 발생")
    void inputDuplicateLottoNumberString() {
        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> new LottoNumber("1, 2, 5, 4, 5, 10"))
                        .withMessage(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> new LottoNumber(Arrays.asList(1, 2, 5, 4, 5, 10)))
                        .withMessage(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER)
        );
    }

    @ParameterizedTest(name = "로또 번호({0})와 당첨 번호({1})의 {2} 등수 확인")
    @MethodSource("parameterGetLottoRank")
    void getLottoRank(List<Integer> pickNumber, List<Integer> winningNumber, LottoRank expected) {
        LottoNumber pickLottoNumber = new LottoNumber(pickNumber);
        LottoNumber winningLottoNumber = new LottoNumber(winningNumber);

        assertEquals(expected, pickLottoNumber.getLottoRank(winningLottoNumber));
    }

    public static Stream<Arguments> parameterGetLottoRank() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        LottoRank.FIRST
                ),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 7),
                        LottoRank.SECOND
                ),
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 7, 8),
                        LottoRank.THIRD
                )
        );
    }
}
