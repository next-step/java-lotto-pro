package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.domain.LottoNumbersBundle;
import step3.domain.strategy.numbers.RandomLottoNumbers;

public class LottoNumbersBundleTest {

    @Test
    void addLottoNumbers() {
        new LottoNumbersBundle().addLottoNumbers(new RandomLottoNumbers());
    }

    @Test
    @DisplayName("출력된 로또번호는 불변성객체로 수정불가 테스트")
    void toArrayUnmodifiableTest() {
        // given

        assertThatThrownBy(() -> {
            // when
            LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle();
            lottoNumbersBundle.addLottoNumbers(new RandomLottoNumbers());
            lottoNumbersBundle.toList().remove(0);
        })// then
            .isInstanceOf(UnsupportedOperationException.class);
    }

}
