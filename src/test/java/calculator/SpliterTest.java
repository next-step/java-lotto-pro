package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SpliterTest {
    private Spliter spliter = new Spliter();

    @Test
    public void basic_delimiter_1() {
        Numbers numbers = spliter.split("1,2");
        assertThat(numbers.getNumbers()[0]).isEqualTo("1");
        assertThat(numbers.getNumbers()[1]).isEqualTo("2");
    }

    @Test
    public void basic_delimiter_2() {
        Numbers numbers = spliter.split("1,2:3");
        assertThat(numbers.getNumbers()[0]).isEqualTo("1");
        assertThat(numbers.getNumbers()[1]).isEqualTo("2");
        assertThat(numbers.getNumbers()[2]).isEqualTo("3");
    }

    @Test
    public void custom_delimiter() {
        Numbers numbers = spliter.split("//;\n1;2;3");
        assertThat(numbers.getNumbers()[0]).isEqualTo("1");
        assertThat(numbers.getNumbers()[1]).isEqualTo("2");
        assertThat(numbers.getNumbers()[2]).isEqualTo("3");
    }
}
