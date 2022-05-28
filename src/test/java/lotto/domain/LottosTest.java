package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    public void 로또_생성_자동() {
        Lottos autoLottos = new Lottos(14);
        assertThat(autoLottos.getLottosSize()).isEqualTo(14);
    }

    @Test
    public void 로또_수동_자동_병합_개수_확인(){
        Lottos autoLottos = new Lottos(10);
        List<Lotto> manualSheets = new ArrayList<>();
        manualSheets.add(new Lotto(new String[]{"1","2","3","4","5","6"}));
        manualSheets.add(new Lotto(new String[]{"1","2","3","4","5","7"}));
        manualSheets.add(new Lotto(new String[]{"1","2","3","4","5","8"}));

        Lottos manualLotto = new Lottos(manualSheets);

        autoLottos.mergeLottos(manualLotto);
        assertThat(autoLottos.getLottosSize()).isEqualTo(13);
    }
}