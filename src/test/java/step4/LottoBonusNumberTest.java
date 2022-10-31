package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.LottoNumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusNumberTest {

    @Test
    @DisplayName("입력받은 보너스 숫자는 1~45사이로 이루어진 숫자형이어야 한다.")
    void input_bonus_number_is_numberic() {
        assertThatThrownBy(() -> new LottoNumber("52"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber("숫자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
