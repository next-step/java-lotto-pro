package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimitersTest {
    @DisplayName("커스텀 구분자 없이 입력")
    @Test
    void inputWithoutCustomDelimiter() {
        // given
        Delimiters delimiters = new Delimiters();
        // when
        String[] numbersText = delimiters.splitTextByDelimiter("1,2,3");
        Numbers numbers = new Numbers(numbersText);
        // then
        assertThat(numbers).isEqualTo(new Numbers(Arrays.asList(new Number("1"), new Number("2"), new Number("3"))));
    }

    @DisplayName("커스텀 구분자 있는 입력")
    @Test
    void inputWithCustomDelimiter() {
        // given
        Delimiters delimiters = new Delimiters("b");
        // when
        String[] numbersText = delimiters.splitTextByDelimiter("1b2b3");
        Numbers numbers = new Numbers(numbersText);
        // then
        assertThat(numbers).isEqualTo(new Numbers(Arrays.asList(new Number("1"), new Number("2"), new Number("3"))));
    }
}
