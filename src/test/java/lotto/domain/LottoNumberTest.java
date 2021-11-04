package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 자동 생성 확인")
    public void autoLottoTest() {
        LottoNumber lottoNumber = new LottoNumber();

        List<Number> numbers = lottoNumber.getLottoNumber();

        assertThat(numbers.size()).isEqualTo(6);
    }

    static Stream<Arguments> listProvide() {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6);
        return Stream.of(arguments(number));
    }

    @ParameterizedTest
    @MethodSource("listProvide")
    @DisplayName("로또 번호 수동 생성 확인")
    public void activeLottoTest(List<Integer> activeNumbers) {
        LottoNumber lottoNumber = new LottoNumber();

        List<Number> numbers = lottoNumber.getLottoNumber(activeNumbers);

        assertThat(numbers).containsExactly(new Number(1), new Number(2), new Number(3),
                new Number(4), new Number(5), new Number(6));
    }

    static Stream<Arguments> listProvide2() {
        List<Integer> number = Arrays.asList(99, 2, 3, 4, 5, 6);
        return Stream.of(arguments(number));
    }

    @ParameterizedTest
    @MethodSource("listProvide2")
    @DisplayName("로또 번호 범위 검증")
    public void activeLottoRange(List<Integer> activeNumbers) {
        LottoNumber lottoNumber = new LottoNumber();

        assertThatThrownBy(() -> {
            List<Number> numbers = lottoNumber.getLottoNumber(activeNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

}