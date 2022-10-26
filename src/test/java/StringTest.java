import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName(",로 split을 했을 때 분리가 잘 되는지 확인")
    void split_test_01() {
        //given
        String input = "1,2";
        String[] expect = {"1", "2"};

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly(expect);
    }

    @Test
    @DisplayName("1, 로 split을 했을 때 1만 포함하는 배열이 반환되는지 확인")
    void split_test_02() {
        //given
        String input = "1,";
        String[] expect = {"1"};

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).contains("1");
        assertThat(result).containsExactly(expect);
    }
}
