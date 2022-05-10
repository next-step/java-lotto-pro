import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    public void test_split_contains_1_or_2() {
        String[] underTest = "1,2".split(",");

        assertThat(underTest).contains("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    public void test_split_contains_exactly_1() {
        String[] underTest = "1".split(",");

        assertThat(underTest).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)을 substring 했을 때 시작, 끝 index를 지정해주면 ()을 제거하고 1,2를 반환하는지 확인")
    public void test_substring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

}
