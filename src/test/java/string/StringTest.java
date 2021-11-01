package string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @Test
    void splitTest() {
        String[] array1 = "1,2".split(",");
        String[] array2 = "1".split(",");

        assertAll(
                () -> assertThat(array1).contains("1","2"),
                () -> assertThat(array2).containsExactly("1"));
    }

    @Test
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
}
