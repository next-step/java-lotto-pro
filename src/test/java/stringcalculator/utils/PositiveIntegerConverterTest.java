package stringcalculator.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static stringcalculator.utils.PositiveNumberConverter.convertToPositiveNumbers;

import java.util.List;
import org.junit.jupiter.api.Test;
import stringcalculator.vo.PositiveNumber;

class PositiveIntegerConverterTest {

    @Test
    void convertTest() {
        String[] input = new String[]{"1", "2", "3"};
        List<PositiveNumber> result = convertToPositiveNumbers(input);
        assertThat(result).containsExactly(PositiveNumber.from("1"), PositiveNumber.from("2"), PositiveNumber.from("3"));
    }
}
