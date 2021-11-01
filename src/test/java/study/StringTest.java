package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @DisplayName("요구사항1 - \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    @Test
    void split() {
        // given
        String str = "1,2";

        // when
        String[] result = str.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("요구사항1 - \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    @Test
    void split_single() {
        // given
        String str = "1";

        // when
        String[] result = str.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @DisplayName("요구사항2 - \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
    @Test
    void substring() {
        // given
        String str = "(1,2)";

        // when
        String result = str.substring(1, str.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }


    @DisplayName("요구사항3 - \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    @Test
    void charAt() {
        // given
        String str = "abc";

        // when
        char c0 = str.charAt(0);
        char c1 = str.charAt(1);
        char c2 = str.charAt(2);

        // then
        assertThat(c0).isEqualTo('a');
        assertThat(c1).isEqualTo('b');
        assertThat(c2).isEqualTo('c');
    }

    @DisplayName("요구사항3 - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 발생하는 부분에 대한 학습 테스트")
    @Test
    void charAt_StringIndexOutOfBoundsException() {
        // given
        String str = "abc";
        int index = 3;

        // when & then
        assertThatThrownBy(() -> str.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %d", index);
    }
}
