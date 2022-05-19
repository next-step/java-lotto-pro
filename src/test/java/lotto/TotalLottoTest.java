package lotto;

import lotto.domain.TotalLotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TotalLottoTest {
    @Test
    public void 구매한_로또_개수_count() throws IllegalArgumentException {
        TotalLotto totalLotto = TotalLotto.from(14000);
        assertThat(totalLotto.getCount()).isEqualTo(14);
    }

    @Test
    public void 구매금액_negative() throws IllegalArgumentException {
        assertThatThrownBy(() -> TotalLotto.from(-14000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매금액_잔액_존재() throws IllegalArgumentException {
        assertThatThrownBy(() -> TotalLotto.from(14500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
