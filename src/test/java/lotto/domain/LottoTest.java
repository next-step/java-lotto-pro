package lotto.domain;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {

    static Stream<Arguments> matchCalculationParametersProvider() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return Stream.of(
                arguments(lottoNumbers, Stream.of(1,2,3,11,22,33)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), 3),
                arguments(lottoNumbers, Stream.of(1,2,3,4,11,22)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), 4),
                arguments(lottoNumbers, Stream.of(1,2,3,4,5,11)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), 5),
                arguments(lottoNumbers, Stream.of(1,2,3,4,5,6)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), 6)
        );

    }

    @DisplayName("로또 번호가 6개가 아닐 시 예외")
    @Test
    void lottoNumberNotSixExceptionTest() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 5)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).withMessage(ErrorMessage.LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호가 중복일 시 예외")
    @Test
    void lottoNumberDuplicateExceptionTest() {
        List<LottoNumber> duplicateLottoNumbers = Stream.of(1, 2, 3, 4, 5, 5)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(duplicateLottoNumbers);
        }).withMessage(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getMessage());
    }

    @DisplayName("로또 번호가 1부터 45 사이가 아닐 시 예외")
    @Test
    void lottoNumberRangExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(46);
        }).withMessage(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
    }

    @DisplayName("당첨 번호 일치 계산")
    @ParameterizedTest
    @MethodSource("matchCalculationParametersProvider")
    void matchCalculation(List<LottoNumber> lottoNumber, Lotto winningNumber, int winningNumberMatchCount) {
        //given
        Lotto lotto = new Lotto(lottoNumber);

        //when
        int winningNumberMatchResult = lotto.winningNumberMatchCount(winningNumber);

        //then
        assertThat(winningNumberMatchResult).isEqualTo(winningNumberMatchCount);
    }
}
