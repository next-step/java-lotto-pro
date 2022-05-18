package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.constant.LottoSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또 숫자로 사용할 최솟값과 최댓값 범위에 맞는지 확인")
    void 숫자가_정해진_숫자_범위인지_체크() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(LottoSetting.LOTTO_NUMBER_RANGE_MIN - 1));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(LottoSetting.LOTTO_NUMBER_RANGE_MAX + 1));
    }

}
