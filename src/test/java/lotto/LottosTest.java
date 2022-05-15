package lotto;

import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    public void 로또_그룹_생성_후_출력() {
        Lottos lottos = new Lottos(5);
        lottos.printLottoList();
    }
}
