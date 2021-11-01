package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    private static Stream<Arguments> splitTest() {
        return Stream.of(
                Arguments.of("1,2", new String[] {"1", "2"}),
                Arguments.of("1", new String[] {"1"})
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("문자열 나누기 검증")
    public void splitTest(String input, String[] result){
        assertThat(input.split(",")).containsExactly(result);
    }

    @Test
    @DisplayName("괄호 제거 검증")
    public void substringTest() {
        String input = "(1,2)";

        String result = input.substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "abc,0,a","abc,2,c"
    },delimiter = ',')
    @DisplayName("한글자 뽑기 성공 테스트")
    public void substringTest_ok(String input, int index, char findItem) {
        assertThat(input.charAt(index)).isEqualTo(findItem);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "abc,3"
    },delimiter = ',')
    @DisplayName("한글자 뽑기 실패 테스트")
    public void substringTest_fail(String input, int index) {
        assertThatThrownBy(
                () -> input.charAt(index)
        ).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 3");
    }

}
