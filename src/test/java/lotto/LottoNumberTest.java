package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 숫자 테스트")
public class LottoNumberTest {
    @ParameterizedTest(name = "{index}. {0} 로또 숫자 테스트")
    @MethodSource("provideNumberForSingleNumberTest")
    void singleNumberFromNumberTest(String title, LottoNumber prizeNumber, LottoNumber myNumber, boolean expect) {
        assertThat(prizeNumber.equals(myNumber)).isEqualTo(expect);
    }

    private static Stream<Arguments> provideNumberForSingleNumberTest() {
        return Stream.of(
                Arguments.of("1 - 1", new LottoNumber(1), new LottoNumber(1), true),
                Arguments.of("1 - 4", new LottoNumber(1), new LottoNumber(4), false)
        );
    }

    @ParameterizedTest(name = "{index}. {0} 로또 숫자 테스트")
    @MethodSource("provideNumbersForNumberTest")
    void singleNumberFromMultipleNumberTest(String title, Set<LottoNumber> prizeNumbers, LottoNumber myNumber, boolean expect) {
        assertThat(prizeNumbers.contains(myNumber)).isEqualTo(expect);
    }

    private static Stream<Arguments> provideNumbersForNumberTest() {
        return Stream.of(
                Arguments.of("1,2,3 - 1",
                        Stream.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3))
                                .collect(Collectors.toSet()),
                        new LottoNumber(1), true),
                Arguments.of("1,3,5 - 4",
                        Stream.of(new LottoNumber(1), new LottoNumber(3), new LottoNumber(5))
                                .collect(Collectors.toSet()),
                        new LottoNumber(4), false)
        );
    }

}
