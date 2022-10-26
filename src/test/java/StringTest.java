import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("split_분리_테스트")
    @Test
    void split_1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @DisplayName("split_분리_구분자_없을때_문자열_그대로_반환")
    @Test
    void split_2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("substring_활용_반환_테스트")
    @Test
    void substring_1() {
        String inputData = "(1,2)";
        String expectData = "1,2";
        assertThat(inputData.substring(1, 4)).isEqualTo(expectData);
    }

    @DisplayName("charAt()_정상_범위_조회")
    @Test
    void char_at_1() {
        String inputData = "abc";
        assertThat(inputData.charAt(0)).isEqualTo('a');
        assertThat(inputData.charAt(1)).isEqualTo('b');
        assertThat(inputData.charAt(2)).isEqualTo('c');
    }

    @DisplayName("charAt()_범위_넘어갈_경우_에러")
    @Test
    void char_at_2() {
        String inputData = "abc";

        assertThatThrownBy(() -> {
            char testData = inputData.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatThrownBy(() -> {
            char testData = inputData.charAt(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");
    }
}