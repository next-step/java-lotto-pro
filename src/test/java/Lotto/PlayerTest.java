package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    void 금액10000원_수동0장_자동10장_생성_총10장() {
        Player player = new Player(10000);
        player.drawManualAndRemainAuto(0);
        assertThat(player.getTotalLottos().getLottos().size()).isEqualTo(10);
    }

    @Test
    void 금액10000원_수동_금액초과시() {
        Player player = new Player(10000);
        assertThatThrownBy(() -> player.drawManualAndRemainAuto(11))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액10000원_수동_음수입력() {
        Player player = new Player(10000);
        assertThatThrownBy(() -> player.drawManualAndRemainAuto(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
