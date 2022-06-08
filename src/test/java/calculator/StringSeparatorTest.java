package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSeparatorTest {
    @Test
    void separateNumbersWithComma() throws Exception {
        assertThat(new String[]{"1", "2"}).isEqualTo(StringSeparator.split("1,2"));
    }

    @Test
    void separateNumbersWithCommaAndColon() throws Exception {
        assertThat(new String[]{"1", "2", "3"}).isEqualTo(StringSeparator.split("1,2:3"));
    }

    @Test
    void separateNumbersWithCustomSign() throws Exception {
        assertThat(new String[]{"1", "2", "3"}).isEqualTo(StringSeparator.split("//;\n1;2;3"));
    }
}
