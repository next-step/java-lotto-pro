package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
        ThrowingCallable throwingCallable = () -> new LottoNumbers(input);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }

    @Test
    public void 로또번호가_중복이다() {
        //given
        List<Integer> input = Arrays.asList(1, 1, 2, 3, 4, 5);

        //when
        ThrowingCallable throwingCallable = () -> new LottoNumbers(input);

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

    static Stream<Arguments> generateWinningNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 16), LottoRank.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 15, 16), LottoRank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 14, 15, 16), LottoRank.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 13, 14, 15, 16), LottoRank.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("generateWinningNumbers")
    public void 로또번호와_당첨번호_비교_후_당첨결과_반환(List<Integer> inputWinningNumbers, LottoRank rank) {
        //given
        LottoNumbers lottoWinningNumbers = new LottoNumbers(inputWinningNumbers);
// new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        //when
//        lottoNumbers.compareWinningNumbers(lottoWinningNumbers);

        //then
//        assertThat(lottoNumbers.getLottoRank()).isEqualTo(rank);
    }
}