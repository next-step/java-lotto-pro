package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

public class LottosTest {
    
    @Test
    public void makeLottos() {
        Lottos lottos = new Lottos(
            Arrays.asList(new Lotto(() -> Arrays.asList(new LottoNumber(1)))));
        assertThat(lottos).isEqualTo(
            new Lottos(Arrays.asList(new Lotto(() -> Arrays.asList(new LottoNumber(1))))));
    }


}
