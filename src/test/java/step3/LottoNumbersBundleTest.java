package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.domain.LottoNumbers;
import step3.domain.LottoNumbersBundle;
import step3.domain.constance.LottoConstant;
import step3.domain.strategy.numbers.RandomNumbers;

public class LottoNumbersBundleTest {

    @Test
    void create() {
        LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle();
        lottoNumbersBundle.addLottoNumbers(
            new RandomNumbers(LottoConstant.MIN_NUMBER_RANGE, LottoConstant.MAX_NUMBER_RANGE,
                LottoNumbers.MAX_LOTTO_NUMBERS_SIZE));
    }

    @Test
    @DisplayName("출력된 로또번호는 불변성객체로 수정불가 테스트")
    void toArrayUnmodifiableTest() {
        // given
        LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle();
        lottoNumbersBundle.addLottoNumbers(
            new RandomNumbers(LottoConstant.MIN_NUMBER_RANGE, LottoConstant.MAX_NUMBER_RANGE,
                LottoNumbers.MAX_LOTTO_NUMBERS_SIZE));

        assertThatThrownBy(() -> {
            // when
            lottoNumbersBundle.toList().remove(0);
        })// then
            .isInstanceOf(UnsupportedOperationException.class);
    }

}
