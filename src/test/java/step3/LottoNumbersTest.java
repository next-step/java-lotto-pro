package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step3.common.exception.InvalidParamException;
import step3.domain.LottoNumbers;
import step3.domain.constance.LottoConstant;
import step3.domain.numbers.ManualNumbers;
import step3.domain.numbers.NumbersStrategy;
import step3.domain.numbers.RandomNumbers;

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
        NumbersStrategy numbersStrategy = new RandomNumbers(LottoConstant.MIN_NUMBER_RANGE,
            LottoConstant.MAX_NUMBER_RANGE, LottoNumbers.MAX_LOTTO_NUMBERS_SIZE);

        //when
        LottoNumbers lottoNumbers = new LottoNumbers(numbersStrategy);

        // then
        assertThat(lottoNumbers.size()).isEqualTo(LottoNumbers.MAX_LOTTO_NUMBERS_SIZE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7})
    @DisplayName("LottoNumbers.MAX_LOTTO_NUMBERS_SIZE 와 일치 하지 않는경우 예외 발생한다.")
    void createLottoNumbersByBuyCount(int outBoundSize) {
        // given
        NumbersStrategy numbersStrategy = new RandomNumbers(LottoConstant.MIN_NUMBER_RANGE,
            LottoConstant.MAX_NUMBER_RANGE, outBoundSize);

        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                LottoNumbers lottoNumbers = new LottoNumbers(numbersStrategy);
            }) // then
            .withMessageMatching(LottoNumbers.RANGE_OUTBOUNT_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("중복숫자 생성시 예외 발생한다.")
    void lottoNumbersCheckIsDuplicate() {
        // given
        int[] numbers = {1, 2, 3, 4, 6, 6};
        NumbersStrategy numbersStrategy = new ManualNumbers(numbers);

        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                LottoNumbers lottoNumbers = new LottoNumbers(numbersStrategy);
            }) // then
            .withMessageMatching(LottoNumbers.RANGE_OUTBOUNT_SIZE_EXCEPTION_MESSAGE);
    }
}