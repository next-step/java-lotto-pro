package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 분리되는지 테스트")
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 테스트")
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
        assertThat(result).hasSize(1);
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)값이 주어졌을 때 ()을 제거하고, 1,2를 반환하는지 테스트")
    void substring1() {
        String str = "(1,2)".substring(1,4);
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 테스트")
    void charAt1() {
        char str = "abc".charAt(1);
        assertThat(str).isEqualTo('b');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 테스트")
    void charAt2() {
        assertThatThrownBy(() -> "abc".charAt(3))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
    }

}
