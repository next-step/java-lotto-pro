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
        //given
        Lottos expectedLottos = new Lottos(
            Arrays.asList(new Lotto(() -> Arrays.asList(new LottoNumber(1)))));
        //when
        Lottos actualLottos = new Lottos(
            Arrays.asList(new Lotto(() -> Arrays.asList(new LottoNumber(1)))));
        //then
        assertThat(actualLottos).isEqualTo(expectedLottos);
    }


}
