package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @Test
    void splitTest() {
        String[] array1 = "1,2".split(",");
        String[] array2 = "1".split(",");

        assertAll(
                () -> assertThat(array1).contains("1","2"),
                () -> assertThat(array2).containsExactly("1"));
    }

    @Test
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0, a", "1, b", "2, c"})
    @DisplayName("문자열의 인덱스로 특정위치의 문자를 가져온다. 인덱스 범위를 넘을경우 에러가 발생한다.")
    void charAtTest(int index, char result) {
        assertAll(
                () -> assertThat("abc".charAt(index)).isEqualTo(result),
                () -> assertThatThrownBy(() ->
                        "abc".charAt(3))
                        .isInstanceOf(StringIndexOutOfBoundsException.class));
    }
}
