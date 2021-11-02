package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("split 메소드를 사용할 때 올바른 배열이 반환되는지에 대한 학습 테스트")
    void splitTest() {
        assertThat("1,2".split(",")).contains("2", "1");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("substring 메소드를 사용할 때 올바른 값을 반환하는지에 대한 학습 테스트")
    void substringTest() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드를 사용할 때 위치 값을 벗어나는 경우에 대한 학습 테스트")
    void charAtTest() {
        String str = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(str.length()))
                .withMessageContaining("String index out of range: ");
    }
}
