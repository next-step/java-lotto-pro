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

public class LottoWinningNumbersTest {

    @Test
    void 당첨번호는_보너스볼과_다른_번호이다() {
        LottoNumbers lottoWinningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoBonusNumber = LottoNumber.from(7);

        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(lottoWinningNumbers, lottoBonusNumber);

        assertThat(winningNumbers).isEqualTo(new LottoWinningNumbers(lottoWinningNumbers, lottoBonusNumber));
    }

    @Test
    void 보너스볼은_당첨번호와_같을_수_없다() {
        LottoNumbers lottoWinningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoBonusNumber = LottoNumber.from(6);

        ThrowingCallable throwingCallable = () -> new LottoWinningNumbers(lottoWinningNumbers, lottoBonusNumber);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }

    static Stream<Arguments> generateWinningNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, LottoRank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 45), 6, LottoRank.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), 8, LottoRank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 15, 16), 7, LottoRank.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 3, 14, 15, 16), 7, LottoRank.FIFTH),
                Arguments.of(Arrays.asList(1, 2, 13, 14, 15, 16), 7, LottoRank.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("generateWinningNumbers")
    public void 로또번호와_당첨번호_비교_후_당첨결과_반환(List<Integer> inputWinningNumbers, int inputLottoBonusNumber, LottoRank rank) {
        //given
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(new LottoNumbers(inputWinningNumbers), LottoNumber.from(inputLottoBonusNumber));

        //when
        LottoRank lottoRank = lottoWinningNumbers.compareLottoNumbers(lottoNumbers);

        //then
        assertThat(lottoRank).isEqualTo(rank);
    }

}
