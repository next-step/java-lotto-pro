package lotto.util;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class StringToIntegerConvertorTest {

    private static Stream<Arguments> strNumbers() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(new String[]{"11", "22", "31", "42", "43", "45"}, Arrays.asList(11, 22, 31, 42, 43, 45))
        );
    }

    @ParameterizedTest
    @MethodSource("strNumbers")
    @DisplayName("String 타입의 숫자 배열이 주어졌을 때 숫자타입으로 변환되는지 확인")
    void convertStringToNumbers(String[] input, List<Integer> expected) {
        List<Integer> results = StringToIntegerConvertor.convertNumbers(input);
        Assertions.assertThat(results).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "10:10", "45:45"}, delimiter = ':')
    @DisplayName("String 타입의 숫자를 int 타입으로 변환되는지 확인")
    void convertStringToNumber(String input, int expected) {
        int result = StringToIntegerConvertor.convertNumber(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}