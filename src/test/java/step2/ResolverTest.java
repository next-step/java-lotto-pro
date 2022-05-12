package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.ArgumentResolver.DefaultResolver;
import step2.ArgumentResolver.EmptyStringResolver;
import step2.ArgumentResolver.InputSingleNumberResolver;
import step2.ArgumentResolver.Resolver;

public class ResolverTest {

    Resolver defaultResolver = new DefaultResolver();
    Resolver emptyStringResolver = new EmptyStringResolver();
    Resolver inputSingleNumberResolver = new InputSingleNumberResolver();

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
        assertThat(defaultResolver.canResolve(source)).isTrue();
        assertThat(defaultResolver.resolve(source))
            .hasSize(expectedSize)
            .containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @CsvSource(value = {" &1", "   &1"}, delimiter = '&')
    public void emptyStringResolverTest(String source, int expectedSize) {
        assertThat(emptyStringResolver.canResolve(source)).isTrue();
        assertThat(emptyStringResolver.resolve(source))
            .hasSize(expectedSize)
            .containsExactly("0");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void inputSingleNumberResolverTest(String source) {
        assertThat(inputSingleNumberResolver.canResolve(source)).isTrue();
        assertThat(inputSingleNumberResolver.resolve(source))
            .hasSize(1)
            .containsExactly(source);
    }
}
