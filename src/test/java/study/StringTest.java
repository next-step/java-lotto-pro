package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {
    @DisplayName("split 은 구분자를 기준으로 분리한 배열을 반환한다.")
    @Test
    void splitTest() throws Exception {
        //given
        String input = "1,2";
        String delimiter = ",";
        //when
        String[] result = input.split(delimiter);
        //then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("split 은 단건의 데이터도 배열로 반환한다")
    @Test
    void splitSingleTest() throws Exception {
        //given
        String input = "1";
        String delimiter = ",";
        //when
        String[] result = input.split(delimiter);
        //then
        assertThat(result).containsOnly("1");
        assertThat(result).hasSize(1);
    }

    @DisplayName("substring 은 first parameter 부터 second parameter -1 까지 문자열을 자른다")
    @Test
    void substringTest() throws Exception {
        //given
        String input = "(1,2)";
        //when
        String result = input.substring(1, 4);
        //then
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest(name = "charAt() 은 문자열에서 특정 인덱스의 문자를 반환한다")
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAtTest(int index, char c) throws Exception {
        //given
        String input = "abc";
        //when //then
        assertThat(input.charAt(index)).isEqualTo(c);
    }

    @DisplayName("charAt 은 문자열 위치값을 벗어나면 StringIndexOutOfBoundsException 예외를 던진다")
    @Test
    void charAtExceptionTest() throws Exception {
        //given
        String input = "abc";

        //when //then
        assertThatThrownBy(() -> input.charAt(3))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> input.charAt(4))
            .withMessageMatching("String index out of range: \\d+");
    }
}
