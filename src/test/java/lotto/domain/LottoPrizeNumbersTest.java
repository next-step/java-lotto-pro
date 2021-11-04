package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

public class LottoPrizeNumbersTest {

    @Test
    public void 당첨번호가_6자리가_맞다() {
        //given
        String[] inputPrizeNumbers = {"1", "2", "3", "4", "5", "6"};

        //when
        LottoPrizeNumbers lottoPrizeNumbers = new LottoPrizeNumbers(inputPrizeNumbers);

        //then
        assertThat(lottoPrizeNumbers.getPrizeNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 당첨번호가_6자리가_아니다() {
        //given
        String[] inputPrizeNumbers = {"1", "2", "3", "4", "5"};

        //when
        ThrowingCallable throwingCallable = () -> new LottoPrizeNumbers(inputPrizeNumbers);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }

    @Test
    public void 당첨번호가_중복이다() {
        //given
        String[] inputPrizeNumbers = {"1", "1", "3", "4", "5", "6"};

        //when
        ThrowingCallable throwingCallable = () -> new LottoPrizeNumbers(inputPrizeNumbers);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }

    @Test
    public void 당첨번호가_1과_45_사이이다() {
        //given
        String[] inputPrizeNumbers = {"1", "2", "3", "4", "5", "45"};

        //when
        LottoPrizeNumbers lottoPrizeNumbers = new LottoPrizeNumbers(inputPrizeNumbers);

        //then
        assertThat(lottoPrizeNumbers.getPrizeNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 당첨번호가_1과_45_사이가_아니다() {
        //given
        String[] inputPrizeNumbers = {"0", "2", "3", "4", "5", "46"};

        //when
        ThrowingCallable throwingCallable = () -> new LottoPrizeNumbers(inputPrizeNumbers);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }
}
