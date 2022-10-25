package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @DisplayName("'1,2'를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void split_comma() {
        String[] strings = "1,2".split(",");

        assertAll(
            () -> assertThat(strings).hasSize(2),
            () -> assertThat(strings).containsExactly("1", "2")
        );
    }

    @DisplayName("'1'을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @Test
    void split_1() {
        String[] strings = "1".split(",");

        assertAll(
            () -> assertThat(strings).hasSize(1),
            () -> assertThat(strings).containsExactly("1")
        );
    }

    @DisplayName("'(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환되는지 확인")
    @Test
    void substring() {
        String string = "(1,2)";

        String substring = string.substring(1, string.length() - 1);

        assertAll(
            () -> assertThat(substring).isEqualTo("1,2")
        );
    }

    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    @Test
    void charAt() {
        String string = "abc";

        assertAll(
            () -> assertThat(string.charAt(0)).isEqualTo('a'),
            () -> assertThat(string.charAt(1)).isEqualTo('b'),
            () -> assertThat(string.charAt(2)).isEqualTo('c')
        );
        assertThatThrownBy(() -> string.charAt(3))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
