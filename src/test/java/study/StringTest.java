package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 분리되는지 테스트")
    @Test
    void splitTest1() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

}
