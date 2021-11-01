package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split 메소드를 이용한 기본적인 문자열 쪼개기 검증")
    public void 문자열_쪼개기_검증() throws Exception{
        String[] split = "1,2".split(",");
        assertThat(split).containsExactly("1","2");
    }

    @Test
    @DisplayName("split 메소드를 이용한 기본적인 문자열 쪼개기 검증")
    public void 문자열_쪼개기_검증2() throws Exception{
        String[] split = "1".split(",");
        assertThat(split).contains("1");
    }

    @Test
    @DisplayName("substring 메소드를 이용한 특정 문자 제거 후 반환")
    public void 특정_문자열_제거() throws Exception{
        String replaceString = "(1,2)".substring(1, 4);
        assertThat(replaceString).isEqualTo("1,2");
    }


    @DisplayName("charAt 메소드를 이용한 특정 위치 문자 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"0,a","1,b","2,c"})
    public void 특정_문자_가져오기(int index, char expected) throws Exception{
        String str = "abc";
        char charAt = str.charAt(index);

        assertThat(charAt).isEqualTo(expected);
    }


    @DisplayName("문자열 길이 초과시 예외 검증")
    @ParameterizedTest
    @ValueSource(ints = {3})
    public void 문자열_길이_초과_검증(int index) throws Exception{
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + str.length());
    }

    @Test
    @DisplayName("AssertJ 학습용")
    public void 배열의_첫번째값_확인() throws Exception{
        String[] split = "1,2".split(",");
        assertThat(split).startsWith("1");
    }

    @Test
    @DisplayName("AssertJ 학습용")
    public void 체이닝() throws Exception{
        String[] split = "A,B,C,D,E,F".split(",");
        assertThat(split)
                .isNotEmpty() // 비어있지 않고
                .contains("E")
                .doesNotContain("G") // G 를 포함하지 않고
                .contains("B","D"); // B 와 D가 존재하는지
    }

}
