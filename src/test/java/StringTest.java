import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split 검증")
    public void split_test() {
        String input = "1,2";

        assertThat(input.split(",")).contains("1");
        assertThat(input.split(",")).contains("2");
        assertThat(input.split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("(1,2) 중에서 substring을 이용하여 () 을 제거하고 1,2 반환 테스트")
    void substring_test() {
        String input = "(1,2)";

        assertThat(input.substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 사용 시 StringIndexOutOfBoundsException 발생 부분 확인 테스트")
    void charAt_Exception_test() {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: 4");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(3);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
