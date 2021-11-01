package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("split 메서드를 호출한다.")
    void split1() {
        // when
        String[] values = "1,2".split(",");

        // then
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split 메서드를 단일 값으로 호출한다.")
    void split2() {
        // when
        String[] values = "1".split(",");

        // then
        assertThat(values).contains("1");
    }

    @Test
    @DisplayName("substring 메서드를 호출한다.")
    void substring() {
        // when
        String result = "(1,2)".substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메서드를 호출한다.")
    void charAt() {
        // when
        char result = "abc".charAt(1);

        // then
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt 메서드를 범위를 벗어난 인덱스로 호출하면 예외가 발생한다.")
    void charAt_exception() {
        // when & then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }
}
