package nextstep.lotto.domain;

import nextstep.lotto.exception.LottoRuntimeException;
import nextstep.lotto.util.LottoRandomGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LottoNumbersTest {

    @DisplayName("유효한 로또 넘버 생성자 테스트")
    @ParameterizedTest
    @MethodSource("provide")
    public void LottoNumbersConstructorTest(List<LottoNumber> expected) {

        // given
        MockedStatic<LottoRandomGenerator> mockRandoms = Mockito.mockStatic(LottoRandomGenerator.class);
        mockRandoms.when(() ->
                LottoRandomGenerator.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())
        ).thenReturn(1, 2, 3, 4, 5, 6);

        // when
        LottoNumbers lottoNumbers = new LottoNumbers();

        // then
        int index = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            Assertions.assertThat(lottoNumber).isEqualTo(expected.get(index++));
        }

        mockRandoms.close();
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6)
                        )
                )
        );
    }

    @DisplayName("유효한 로또 넘버 생성자 테스트")
    @Test
    public void constructorExceptionTest() {
        Assertions.assertThatThrownBy(() -> {
            LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(
                    new LottoNumber(10),
                    new LottoNumber(21),
                    new LottoNumber(26),
                    new LottoNumber(30),
                    new LottoNumber(60),
                    new LottoNumber(70)
            ));
        }).isInstanceOf(LottoRuntimeException.class);
    }
}
