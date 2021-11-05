package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class LottoNumbersTest {

    @Test
    public void 로또번호가_6자리가_맞다() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        LottoNumbers lottoNumbers = new LottoNumbers(input);

        //then
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 로또번호가_6자리가_아니다() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);

        //when
        ThrowingCallable throwingCallable = () ->  new LottoNumbers(input);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }

    @Test
    public void 로또번호가_중복이다() {
        //given
        List<Integer> input = Arrays.asList(1, 1, 2, 3, 4, 5);

        //when
        ThrowingCallable throwingCallable = () ->  new LottoNumbers(input);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }

    @Test
    public void 로또번호가_1과_45_사이이다() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        LottoNumbers lottoNumbers = new LottoNumbers(input);

        //then
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 로또번호가_1과_45_사이가_아니다() {
        //given
        List<Integer> input = Arrays.asList(1, 1, 2, 3, 4, 46);

        //when
        ThrowingCallable throwingCallable = () -> new LottoNumbers(input);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }
}