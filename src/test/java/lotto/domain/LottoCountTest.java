package lotto.domain;

import lotto.exception.LottoCountException;
import lotto.exception.LottoNumberRangeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCountTest {

    @Test
    @DisplayName("입력된 수동 로또 개수가 의도된 개수와 일치해야 한다.")
    void 수동_로또번호_생성_정상() {
        Assertions.assertThat(new LottoCount(3).value())
            .isEqualTo(3);
    }

    @Test
    @DisplayName("수동 로또 로또번호가 음수이면 예외가 발생되어야 한다.")
    void 수동_로또번호_음수_예외() {
        Assertions.assertThatThrownBy(() -> new LottoCount(-1))
            .isInstanceOf(LottoCountException.class);
    }

}