package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.utils.StringToStringArrayResolver.resolve;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringToStringArrayResolverTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3&,&3", "1,2,3&:&1", "1:2:3&:&3", "1:2:3&,&1"}, delimiter = '&')
    @DisplayName("Source와 Delimiter별 Split결과 확인")
    public void checkSplit(String source, String delimiter, int size) {
        assertThat(source.split(delimiter)).hasSize(size);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3&,&true", "1,2,3&:&false", "1:2:3&:&true", "1:2:3&,&false"}, delimiter = '&')
    @DisplayName("delimiter가 정상적으로 확인되는가")
    public void checkDelimiter(String source, String delimiter, boolean expected) {
        assertThat(source.indexOf(delimiter) != -1).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3&3", "1,2,3&3", "1:2:3&3", "1:2,3&3"}, delimiter = '&')
    public void defaultResolverTest(String source, int expectedSize) {
        assertThat(resolve(source))
            .hasSize(expectedSize)
            .containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @CsvSource(value = {" &1", "   &1"}, delimiter = '&')
    public void emptyStringResolverTest(String source, int expectedSize) {
        assertThat(resolve(source))
            .hasSize(expectedSize)
            .containsExactly("0");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void inputSingleNumberResolverTest(String source) {
        assertThat(resolve(source))
            .hasSize(1)
            .containsExactly(source);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//:\n1:2:3", "//!\n1!2!3"})
    public void customResolverTest(String source) {
        assertThat(resolve(source))
            .hasSize(3)
            .containsExactly("1", "2", "3");
    }
}
