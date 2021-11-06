package lotto.domain;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @DisplayName("로또 번호가 6개가 아닐 시 예외")
    @Test
    void lottoNumberNotSixExceptionTest() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(1, 5)
                .boxed()
                .collect(Collectors.toList());

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).withMessage(ErrorMessage.LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호가 중복일 시 예외")
    @Test
    void lottoNumberDuplicateExceptionTest() {
        List<Integer> duplicateLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(duplicateLottoNumbers);
        }).withMessage(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getMessage());
    }

    @DisplayName("로또 번호가 1부터 45 사이가 아닐 시 예외")
    void lottoNumberRangExceptionTest() {
        List<Integer> rangeOutLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(rangeOutLottoNumbers);
        }).withMessage(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
    }
}
