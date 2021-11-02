package calculator.module;

import calculator.domain.Numbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SeparatorTest {

    @ParameterizedTest
    @CsvSource({
            "'//?\n1?2?3',3"
            , "'1,2,3',3"
            , "'0,65:4',3"
    })
    @DisplayName("입력받은 문자열 나누기")
    public void separateTest(String input, int resultSize){
        Separator separator = Separator.separate(input);
        Numbers numbers = separator.splitSeparated();

        Assertions.assertThat(numbers.getNumberList().size()).isEqualTo(resultSize);
    }
}
