package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.common.exception.InvalidParamException;
import step3.domain.LottoNumbers;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.domain.strategy.numbers.RandomLottoNumbers;

public class LottoNumbersTest {

    @Test
    void create() {
        // given
        int lottoBuyCount = 5;

        // when
        LottoNumbers lottoNumbers = new LottoNumbers();

        // then
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers());
    }

    @Test
    @DisplayName("LottoNumbers 를 생성한다. size 는 LottoNumbers.MAX_LOTTO_NUMBERS_SIZE 이다.")
    void createLottoNumbers() {
        // given
        NumbersStrategy numbersStrategy = new RandomLottoNumbers();

        //when
        LottoNumbers lottoNumbers = new LottoNumbers(numbersStrategy.getNumbers());

        // then
        assertThat(lottoNumbers.size()).isEqualTo(LottoNumbers.MAX_LOTTO_NUMBERS_SIZE);
    }

    @Test
    @DisplayName("LottoNumbers.MAX_LOTTO_NUMBERS_SIZE 와 일치 하지 않는경우 예외 발생한다.")
    void createLottoNumbersByBuyCount() {
        // given
        int[] overSizeNumbers = new int[] {1, 2, 3, 4, 5, 6, 7};

        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                new LottoNumbers(overSizeNumbers);
            }) // then
            .withMessageMatching(LottoNumbers.RANGE_OUTBOUND_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("중복숫자 생성시 예외 발생한다.")
    void lottoNumbersCheckIsDuplicate() {
        // given
        int[] numbers = {1, 2, 3, 4, 6, 6};

        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                new LottoNumbers(numbers);
            }) // then
            .withMessageMatching(LottoNumbers.RANGE_OUTBOUND_SIZE_EXCEPTION_MESSAGE);
    }

    private NumbersStrategy getNumbersStrategy(int[] overSizeNumbers) {
        return new NumbersStrategy() {
            @Override
            public int[] getNumbers() {
                return overSizeNumbers;
            }
        };
    }
}
