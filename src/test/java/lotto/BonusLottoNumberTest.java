package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusLottoNumberTest {

    @Test
    void 보너스_로또번호는_생성시_다른_로또와_겹치면_안된다() {
        assertThatThrownBy(() -> BonusLottoNumber.valueOf(3,
            Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
