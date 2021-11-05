package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import step3.domain.LottoNumbers;
import step3.domain.LottoNumbersBundle;
import step3.domain.numbers.NumbersStrategy;
import step3.domain.numbers.RandomNumbers;

public class LottoNumbersBundleTest {
    @Test
    void create() {
        LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle();
        lottoNumbersBundle.addLottoNumbers(new LottoNumbers());
    }

}
