package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

        assertThat(lottoNumber.getLottoNumber().size()).isEqualTo(6);
    }

    static Stream<Arguments> listProvide() {
        List<Number> number = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        return Stream.of(arguments(number));
    }

    @ParameterizedTest
    @MethodSource("listProvide")
    @DisplayName("로또 번호 수동 생성 확인")
    public void activeLottoTest(List<Number> activeNumbers) {
        LottoNumber lottoNumber = new LottoNumber(activeNumbers);

        assertThat(lottoNumber.getLottoNumber()).containsExactly(new Number(1), new Number(2), new Number(3),
                new Number(4), new Number(5), new Number(6));
    }

    @Test
    @DisplayName("로또 번호 범위 검증")
    public void activeLottoRange() {
        assertThatThrownBy(() -> {
            List<Number> activeNumbers = Arrays.asList(new Number(99), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


    static Stream<Arguments> listProvide3() {
        List<Number> number = Arrays.asList(new Number(1), new Number(2), new Number(3),
                new Number(4), new Number(5), new Number(6), new Number(7));
        return Stream.of(arguments(number));
    }

    @ParameterizedTest
    @MethodSource("listProvide3")
    @DisplayName("로또 번호 길이 검증")
    public void activeLottoNumberSize(List<Number> activeNumbers) {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(activeNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}