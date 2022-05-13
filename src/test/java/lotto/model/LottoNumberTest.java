package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
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
        LottoNumber lottoNumber = LottoNumber.of(list);

        assertEquals(lottoNumber, LottoNumber.of(list));
    }

    @ParameterizedTest(name = "잘못된 문자열({0}) 로또 번호를 입력받을 때 IllegalArgumentException가 발생")
    @ValueSource(strings = {"1,2,3,4,5", "5, 8, 10, 12, 16, 18, 20", "1, 2, 3, 4, 5, a"})
    void inputInvalidLottoNumberString(String invalidLottoNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(invalidLottoNumber))
                .withMessage("올바른 로또 번호 양식이 아닙니다.");
    }

    @Test
    @DisplayName("로또 번호를 벗어난 값을 입력받을 때 IllegalArgumentException가 발생")
    void inputOutOfRangeLottoNumberString() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of("1, 2, 3, 4, 5, 100"))
                .withMessage("로또 숫자 범위를 벗어났습니다.");
    }

    @Test
    @DisplayName("로또 번호를 중복된 값을 입력받을 때 IllegalArgumentException가 발생")
    void inputDuplicateLottoNumberString() {
        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> LottoNumber.of("1, 2, 5, 4, 5, 10"))
                        .withMessage("로또 숫자의 중복은 허용되지 않습니다."),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> LottoNumber.of(Arrays.asList(1, 2, 5, 4, 5, 10)))
                        .withMessage("로또 숫자의 중복은 허용되지 않습니다.")
        );
    }

    @ParameterizedTest(name = "로또 번호({0})와 당첨 번호({1})의 {2} 등수 확인")
    @MethodSource("parameterGetLottoRank")
    void getLottoRank(List<Integer> pickNumber, List<Integer> winningNumber, LottoRank expected) {
        LottoNumber pickLottoNumber = LottoNumber.of(pickNumber);
        LottoNumber winningLottoNumber = LottoNumber.of(winningNumber);

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
