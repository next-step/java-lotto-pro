package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StudyTest {

    @Test
    @DisplayName("요구사항 1-1. \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    void splitMultipleValuesWithCommaTest() {
        assertThat("1,2".split(","))
                .isInstanceOf(String[].class)
                .hasOnlyElementsOfType(String.class)
                .hasSize(2)
                .containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 1-2. \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.")
    void splitSingleValueWithCommaTest() {
        assertThat("1,".split(","))
                .isInstanceOf(String[].class)
                .hasOnlyElementsOfType(String.class)
                .hasSize(1)
                .containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2. \"(1,2)\"이 주어졌을 때 substring()을 활용해 \"1,2\"를 반환한다.")
    void substringTest() {
        String value = "(1,2)";
        assertThat(value.substring(1, value.length() - 1))
                .isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3-1. \"abc\" 값이 주어졌을 때 charAt()으로 특정 위치 문자를 가져오는지 확인한다.")
    void charAtTest() {
        String value = "abc";

        assertThat(value.charAt(0))
                .isEqualTo('a');
        assertThat(value.charAt(1))
                .isEqualTo('b');
        assertThat(value.charAt(2))
                .isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항 3-2. charAt()으로 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인한다.")
    void charAtStringIndexOutOfBoundsExceptionTest() {
        String value = "abc";
        int index = value.length();

        assertThatThrownBy(() -> value.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %s", index);
    }
}
