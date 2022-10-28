import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorInputTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2:3,4|1,2,3,4|4", "100:200,3|100,200,3|3", "1|1|1"}, delimiter = '|')
    void 구분자에_따른_숫자_추출_테스트(String input, String expectedResultWithComma, int expectedSize) {
        List<Integer> expectedResult = toIntegerList(expectedResultWithComma);

        CalculatorInput calculatorInput = new CalculatorInput(input);
        List<Integer> numbers = calculatorInput.getNumbers();

        assertThat(numbers).hasSize(expectedSize);
        assertThat(numbers).containsAll(expectedResult);
    }

    @Test
    public void 커스텀_구분자에_따른_숫자_추출_테스트() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    private List<Integer> toIntegerList(String expectedResultInComma) {
        String[] split = expectedResultInComma.split(",");

        List<Integer> integerList = new ArrayList<>();
        for (String s : split) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }
}