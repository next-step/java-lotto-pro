package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoTest {

    @Test
    void createLotto() {
        assertThat(new Lotto()).isNotEqualTo(new Lotto());
    }

    @Test
    void createNumbers() {
        Lotto lottoNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoNumbers)
                .usingRecursiveComparison()
                .isEqualTo(new Lotto(Arrays.asList(1,2,3,4,5,6)));
    }

    @DisplayName("숫자 값이 6개가 아닐 경우, 중복 값이 있을 경우")
    @ParameterizedTest
    @MethodSource("numbersParametersProvider")
    void createNumbers_예외처리(List<Integer> numbers) {
        assertAll(
                () -> assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    static Stream<Arguments> numbersParametersProvider() {
        return Stream.of(
                arguments(Arrays.asList(1,2,3,4,5,6,7)),
                arguments(Arrays.asList(1,2,3,4,5)),
                arguments(Arrays.asList(1,2,3,4,5,5))
        );
    }

    @Test
    void isMatchBonus() {
        assertAll(
                () -> assertThat(new Lotto(Arrays.asList(1,2,3,4,5,6)).isMatchBonus(new LottoNumber(5))).isEqualTo(true),
                () -> assertThat(new Lotto(Arrays.asList(1,2,3,4,5,6)).isMatchBonus(new LottoNumber(8))).isEqualTo(false)
        );
    }
}
