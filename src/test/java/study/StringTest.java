package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void canSplitComma() {
        String target = "1,2";

        assertThat(target.split(","))
                .isInstanceOf(String[].class)
                .hasOnlyElementsOfType(String.class)
                .hasSize(2)
                .containsExactly("1", "2");
    }
}
