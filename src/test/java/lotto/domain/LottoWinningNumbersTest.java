package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

public class LottoWinningNumbersTest {

    @Test
    public void 당첨번호가_6자리가_맞다() {
        //given
        String[] inputWinningNumbers = {"1", "2", "3", "4", "5", "6"};

        //when
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(inputWinningNumbers);

        //then
        assertThat(lottoWinningNumbers.getWinningNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 당첨번호가_6자리가_아니다() {
        //given
        String[] inputWinningNumbers = {"1", "2", "3", "4", "5"};

        //when
        ThrowingCallable throwingCallable = () -> new LottoWinningNumbers(inputWinningNumbers);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }

    @Test
    public void 당첨번호가_중복이다() {
        //given
        String[] inputWinningNumbers = {"1", "1", "3", "4", "5", "6"};

        //when
        ThrowingCallable throwingCallable = () -> new LottoWinningNumbers(inputWinningNumbers);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }

    @Test
    public void 당첨번호가_1과_45_사이이다() {
        //given
        String[] inputWinningNumbers = {"1", "2", "3", "4", "5", "45"};

        //when
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(inputWinningNumbers);

        //then
        assertThat(lottoWinningNumbers.getWinningNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 당첨번호가_1과_45_사이가_아니다() {
        //given
        String[] inputWinningNumbers = {"0", "2", "3", "4", "5", "46"};

        //when
        ThrowingCallable throwingCallable = () -> new LottoWinningNumbers(inputWinningNumbers);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }
}
