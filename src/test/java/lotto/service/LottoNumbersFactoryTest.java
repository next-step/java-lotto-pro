package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.LottoNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumbersFactoryTest {
    private final LottoNumbersFactory factory = new LottoNumbersFactory();

    @ParameterizedTest
    @MethodSource("numbersNotHavingSixNumbers")
    @DisplayName("로또 번호 생성 시 번호가 6개가 아니면 IllegalArgumentException을 발생시킨다")
    void when_amount_of_numbers_is_not_six_should_throw_IllegalArgumentException(final List<Integer> numbers) {
        // when and then
        Assertions.assertThatThrownBy(() -> factory.create(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("numbersHavingLessThanOneOrGreaterThanFortyFive")
    @DisplayName("로또 번호 생성 시 1보다 작거나 45보다 큰 번호가 하나라도 있으면 IllegalrgumentException을 발생시킨다")
    void when_number_is_invalid_should_throw_IllegalArgumentException(final List<Integer> numbers) {
        // when and then
        Assertions.assertThatThrownBy(() -> factory.create(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("컴마로 구분된 숫자 6개가 담긴 문자열을 파라미터로 로또 번호가 생성되야 한다")
    void create_by_numbers_string() {
        // given
        final String numbersString = "1, 2, 3, 4, 5, 6";

        // when
        final LottoNumbers lottoNumbers = factory.convertAndCreate(numbersString);

        // then
        assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("로또 번호 생성 시 숫자, 컴마, 공백 외의 문자를 가진 문자열이 파라미터로 들어오면 IllegalArgumentException을 발생시킨다")
    void when_numbersString_cannot_be_converted_to_list_should_throw_IllegalArgumentException() {
        // given
        final List<String> invalidNumbersStrings = Arrays.asList("1 ! 2 a 3 가 4 @ 5 # 6",
                "a, b,c,d,e ,f",
                "1 , 2 , 3 , 4, 5 , a");

        // when and then
        for (final String invalidNumbersString : invalidNumbersStrings) {
            assertThatThrownBy(() -> factory.convertAndCreate(invalidNumbersString))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    private static Stream<Arguments> numbersNotHavingSixNumbers() {
        return Stream.of(Arguments.of(new ArrayList<>()),
                Arguments.of(Arrays.asList(1)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    private static Stream<Arguments> numbersHavingLessThanOneOrGreaterThanFortyFive() {
        return Stream.of(Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 0)),
                Arguments.of(Arrays.asList(-1, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 46, 3, 4, 5)));
    }
}
