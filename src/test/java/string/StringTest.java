package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("String Split Contains 테스트 (Multi Value)")
    @Test
    public void splitContainsTest() {

        String[] splitInputArr = "1,2".split(",");
        assertThat(splitInputArr).contains(splitInputArr[0], splitInputArr[1]);

    }

    @DisplayName("String Split ContainsExactly 테스트 (Single Value)")
    @Test
    public void splitContainsExactlyTest() {

        String input = "1";
        String[] splitInputArr = input.split(",");
        assertThat(splitInputArr).containsExactly(input);

    }

    @DisplayName("String substring 테스트")
    @Test
    public void substringTest() {

        String input = "(1,2)";
        String substringInput = input.substring(1, input.length() - 1);
        assertThat(substringInput).isEqualTo("1,2");

    }

    @DisplayName("[정상] String charAt 테스트")
    @Test
    public void charAtTest() {

        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');

    }

    @DisplayName("[예외] String charAt IndexOutOfBoundsException 테스트")
    @Test
    public void charAtExceptionTest() {

        String input = "abc";
        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
