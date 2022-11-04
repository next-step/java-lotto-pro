package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumbersTest {
    @Test
    void Numbers_인스턴스_생성(){
        String[] arr = {"1", "2", "3"};
        Numbers numbers = new Numbers(arr);
        assertThat(numbers.getNumbers()[0]).isEqualTo("1");
        assertThat(numbers.getNumbers()[1]).isEqualTo("2");
        assertThat(numbers.getNumbers()[2]).isEqualTo("3");
    }
}
