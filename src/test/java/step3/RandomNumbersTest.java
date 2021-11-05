package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import step3.domain.numbers.NumbersStrategy;
import step3.domain.numbers.RandomNumbers;

public class RandomNumbersTest {

    @Test
    void create() {
        NumbersStrategy numbersStrategy = new RandomNumbers(1, 45, 6);

        assertThat(numbersStrategy).isInstanceOf(NumbersStrategy.class);
    }

    @Test
    void createRandomNumberCountTest() {
        NumbersStrategy numbersStrategy = new RandomNumbers(1, 45, 6);

        assertThat(numbersStrategy.getNumbers().length).isEqualTo(6);
    }
}
