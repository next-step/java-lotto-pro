package camp.nextstep.edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {
    private static final String regex = ",";

    @DisplayName("String 의 split 를 이용 하여 분리 작업")
    @ParameterizedTest
    @MethodSource("providerSourceAndExpectedResult")
    void splitTest(final String source, final String[] expectedResult) {
        assertThat(source.split(regex)).hasSize(expectedResult.length)
                .contains(expectedResult)
                .containsExactly(expectedResult);
    }

    private static Stream<Arguments> providerSourceAndExpectedResult() {
        return Stream.of(
                Arguments.of("2,3,4", new String[]{"2", "3", "4"}),
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }

    @DisplayName("contains 와 containsExactly 차이를 알아 보기 위한 테스트")
    @Test
    void isDifference() {
        final String source = "3,4,5";
        final String[] compareStrArray = {"4", "3", "5"};

        assertThat(source.split(regex)).hasSize(3).contains(compareStrArray);
        assertThatExceptionOfType(AssertionError.class)
                .isThrownBy(() -> assertThat(source.split(regex)).containsExactly(compareStrArray));
    }

    @DisplayName("substring 를 통해서 \"(\",\")\" 제거 하기")
    @ParameterizedTest
    @CsvSource(value = {"(1,2):1,2", "(1):1"}, delimiter = ':')
    void substringTest(final String source, final String expectedStr) {
        final String subStringStr = source.substring(findStartParenthesis(source), findEndParenthesis(source));
        assertThat(subStringStr).isEqualTo(expectedStr);
    }

    @DisplayName("\"(\" or \")\" 중 하나라도 있는 경우 제거 하기")
    @ParameterizedTest
    @CsvSource(value = {"(1,2:1,2", "1,2):1,2", "1,2:1,2"}, delimiter = ':')
    void noPairs(final String source, final String expectedResult) {
        substringTest(source, expectedResult);
    }

    @DisplayName("charAt 를 이용하여 특정 위치 문자 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"abc:0:a", "abc:1:b"}, delimiter = ':')
    void charAtTest(final String source, final int index, final char expectedIndexChar) {
        assertThat(source.charAt(index)).isEqualTo(expectedIndexChar);
    }

    @DisplayName("charAt 사용시 입력 길이 보다 크면 StringIndexOutOfBoundsException 이 발생")
    @Test
    void charAtOutOfBoundTest() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "123".charAt(4))
                .withMessageMatching("String index out of range: \\d+");
    }

    private int findStartParenthesis(final String source) {
        return Objects.equals(source.indexOf("("), -1) ? 0 : source.indexOf("(") + 1;
    }

    private int findEndParenthesis(final String source) {
        return Objects.equals(source.lastIndexOf(")"), -1) ? source.length() : source.lastIndexOf(")");
    }
}
