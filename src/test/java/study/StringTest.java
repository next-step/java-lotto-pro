package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    void split_multiple() {
        String given = "1,2";
        String[] when = given.split(",");
        // then
        assertThat(when).contains("1");
        assertThat(when).containsExactly("1", "2");
        assertEquals(when.length, 2);
    }

    @Test
    void split_single() {
        String given = "1";
        String[] when = given.split(",");
        // then
        assertThat(when).containsExactly("1");
        assertThat(when).doesNotContain("2");
        assertEquals(when.length, 1);
    }
}
