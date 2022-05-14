package calculator.add.string.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    @DisplayName("총 합을 구한다")
    void sumTotal_총합() {
        String[] inputNumbers = {"1", "2", "3"};
        Numbers numbers = new Numbers(inputNumbers);

        assertEquals(numbers.sumTotal(), 6);
    }

}
