package step3;

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

}
