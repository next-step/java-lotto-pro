package lotto.domain;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

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
}
