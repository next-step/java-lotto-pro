import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusLottoNumberTest {
    @Test
    void BonusNumber_는_LottoNumber_를_확장한_객체이다() {
        assertThat(new BonusLottoNumber(LottoNumber.LOWER_BOUND)).isInstanceOf(LottoNumber.class);
        assertThat(new BonusLottoNumber(LottoNumber.UPPER_BOUND)).isInstanceOf(LottoNumber.class);

        assertThatThrownBy(() -> new BonusLottoNumber(LottoNumber.LOWER_BOUND - 1))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new BonusLottoNumber(LottoNumber.UPPER_BOUND + 1))
                .isInstanceOf(RuntimeException.class);
    }
}
