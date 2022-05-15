package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호가 1~45 숫자 사이가 아닌 경우")
    @Test
    void bonusNumber_not_lotto_number() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(0))
                .withMessage("[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다.");
    }

}
