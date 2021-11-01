package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("String Split Contains 테스트 (Multi Value)")
    @ParameterizedTest
    @CsvSource(value = {"1,2"}, delimiter = ':')
    public void splitContainsTest(String input) {

        String[] splitInputArr = input.split(",");
        assertThat(splitInputArr).contains(splitInputArr[0], splitInputArr[1]);

    }

    @DisplayName("String Split ContainsExactly 테스트 (Single Value)")
    @ParameterizedTest
    @CsvSource(value = {"1"})
    public void splitContainsExactlyTest(String input) {

        String[] splitInputArr = input.split(",");
        assertThat(splitInputArr).containsExactly(input);

    }

    @DisplayName("String substring 테스트")
    @ParameterizedTest
    @CsvSource(value = {"(1,2)"}, delimiter = ':')
    public void substringTest(String input) {

        String substringInput = input.substring(1, input.length() - 1);
        assertThat(substringInput).isEqualTo("1,2");

    }

    @DisplayName("String charAt 테스트")
    @ParameterizedTest
    @CsvSource(value = {"abc"}, delimiter = ':')
    public void charAtTest(String input) {

        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> input.charAt(5)).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 5");
    }
}
