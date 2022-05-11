package stringcalculator.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static stringcalculator.utils.PositiveIntegerConverter.convertToPositiveIntegers;

import java.util.List;
import org.junit.jupiter.api.Test;

class PositiveIntegerConverterTest {

    @Test
    void convertTest() {
        String[] input = new String[]{"1", "2", "3"};
        List<Integer> result = convertToPositiveIntegers(input);
        assertThat(result).containsExactly(1, 2, 3);
    }
}
