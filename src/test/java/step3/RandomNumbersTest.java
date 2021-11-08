package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import step3.domain.LottoNumbers;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.domain.strategy.numbers.RandomLottoNumbers;

public class RandomNumbersTest {

    @Test
    void createRandomNumberCountTest() {
        NumbersStrategy numbersStrategy = new RandomLottoNumbers();

        assertThat(numbersStrategy.getNumbers().length).isEqualTo(LottoNumbers.MAX_LOTTO_NUMBERS_SIZE);
    }
}
