package Lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @ParameterizedTest
    @CsvSource(value = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"})
    void 금액10000원_수동10장_생성_총10장(int inputManualCount) {
        Player player = new Player(10000);
        player.drawManualAndRemainAuto(inputManualCount);
        assertThat(player.getTotalLottos().getLottos().size()).isEqualTo(10);
    }
}
