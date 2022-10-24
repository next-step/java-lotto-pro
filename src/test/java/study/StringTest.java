package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 테스트한다")
    void splitComma(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 테스트한다다")
    void splitTest2(){
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring(){
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("주어진 문자열의 index를 벗어날 때 발생하는 exception을 테스트 한다")
    void charAtThrowStringOutOfBoundException2(){
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char charAt = "abc".charAt(4);
                }).withMessageMatching("String index out of range: \\d");
    }

}
