package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void split_1_2() {
        String[] strings = "1,2".split(",");
        assertThat(strings).contains("1", "2");
        assertThat(strings).containsExactly("1", "2");
    }

    @Test
    void split_1() {
        String[] strings = "1".split(",");
        assertThat(strings).contains("1");
        assertThat(strings).containsExactly("1");
    }
}
