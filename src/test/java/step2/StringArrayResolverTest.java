package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.argumentresolver.CustomDelimiterStringArrayResolver;
import step2.argumentresolver.DefaultDelimiterStringArrayResolver;
import step2.argumentresolver.EmptyInputStringArrayResolver;
import step2.argumentresolver.SingleNumberStringArrayResolver;
import step2.argumentresolver.StringArrayResolver;

public class StringArrayResolverTest {

    StringArrayResolver defaultStringArrayResolver = new DefaultDelimiterStringArrayResolver();
    StringArrayResolver emptyStringStringArrayResolver = new EmptyInputStringArrayResolver();
    StringArrayResolver inputSingleNumberStringArrayResolver = new SingleNumberStringArrayResolver();
    StringArrayResolver customStringArrayResolver = new CustomDelimiterStringArrayResolver();


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
        assertThat(defaultStringArrayResolver.canResolve(source)).isTrue();
        assertThat(defaultStringArrayResolver.resolve(source))
            .hasSize(expectedSize)
            .containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @CsvSource(value = {" &1", "   &1"}, delimiter = '&')
    public void emptyStringResolverTest(String source, int expectedSize) {
        assertThat(emptyStringStringArrayResolver.canResolve(source)).isTrue();
        assertThat(emptyStringStringArrayResolver.resolve(source))
            .hasSize(expectedSize)
            .containsExactly("0");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void inputSingleNumberResolverTest(String source) {
        assertThat(inputSingleNumberStringArrayResolver.canResolve(source)).isTrue();
        assertThat(inputSingleNumberStringArrayResolver.resolve(source))
            .hasSize(1)
            .containsExactly(source);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//:\n1:2:3", "//!\n1!2!3"})
    public void customResolverTest(String source) {
        assertThat(customStringArrayResolver.canResolve(source)).isTrue();
        assertThat(customStringArrayResolver.resolve(source))
            .hasSize(3)
            .containsExactly("1", "2", "3");
    }
}
