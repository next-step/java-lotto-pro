import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split_bulk() {
        String str = "1,2";

        String[] result = str.split(",");

        assertThat(result).contains("1", "2");
    }

    @Test
    void split_single() {
        String str = "1";

        String[] result = str.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    void substring_remove_front_and_rear() {
        String str = "(1,2)";

        String result = str.substring(1, str.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String의_charAt()은_특정위치의_문자를_가져옴")
    @Test
    void charAt() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @DisplayName("String의_charAt()은_인덱스_범위를_초과하면_exception_발생")
    @Test
    void charAt_outOfBoundException() {
        String str = "abc";
        int outOfBoundIndex = str.length() + 1;

        assertThatThrownBy(() -> {
            str.charAt(outOfBoundIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining(String.format("String index out of range: %s", outOfBoundIndex));
    }
}
