package lotto;

import lotto.service.LottoServiceCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    void 로또_개수_계산() {
        Assertions.assertThat(LottoServiceCalculator.getLottoCount(14000)).isEqualTo(14);
    }
}