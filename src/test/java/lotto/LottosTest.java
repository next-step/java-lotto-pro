package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    public void makeLottos() {
        Lottos lottos = new Lottos(List.of(new Lotto(() -> List.of(new LottoNumber(1)))));
        assertThat(lottos).isEqualTo(
            new Lottos(List.of(new Lotto(() -> List.of(new LottoNumber(1))))));
    }
}
