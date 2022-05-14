package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호를 입력받을 때 값이 동일한지 검증")
    void inputLottoNumberList() {
        List<Number> numberList = Arrays.asList(
                Number.of(1),
                Number.of(2),
                Number.of(3),
                Number.of(4),
                Number.of(5),
                Number.of(6)
        );
        LottoNumber lottoNumber = new LottoNumber(numberList);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(numberList));
    }

    @Test
    @DisplayName("로또 번호를 중복된 값을 입력받을 때 IllegalArgumentException가 발생")
    void inputDuplicateLottoNumberString() {
        List<Number> duplicateNumberList = Arrays.asList(
                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(1), Number.of(6)
        );
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(duplicateNumberList))
                .withMessage("로또 숫자의 중복은 허용되지 않습니다.");
    }

    @ParameterizedTest(name = "로또 번호와 당첨 번호의 {2} 등수 확인")
    @MethodSource("parameterGetLottoRank")
    void getLottoRank(List<Number> pickNumber, List<Number> winningNumber, LottoRank expected) {
        LottoNumber pickLottoNumber = new LottoNumber(pickNumber);
        LottoNumber winningLottoNumber = new LottoNumber(winningNumber);

        assertEquals(expected, pickLottoNumber.getLottoRank(winningLottoNumber));
    }

    public static Stream<Arguments> parameterGetLottoRank() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6)
                        ),
                        Arrays.asList(
                                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6)
                        ),
                        LottoRank.FIRST
                ),
                Arguments.of(
                        Arrays.asList(
                                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6)
                        ),
                        Arrays.asList(
                                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(7)
                        ),
                        LottoRank.SECOND
                ),
                Arguments.of(
                        Arrays.asList(
                                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6)
                        ),
                        Arrays.asList(
                                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(7), Number.of(8)
                        ),
                        LottoRank.THIRD
                )
        );
    }
}
