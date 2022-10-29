package step3.domain.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.domain.statistics.WinningLottoType.findByMatchCount;

class WinningLottoTypeTest {

    @Test
    @DisplayName("당첨 번호 일치 개수에 따라 로또 당첨 유형을 리턴한다.")
    void findWinningLottoTypeByMatchCount() {
        WinningLottoType byMatchCount = findByMatchCount(3);
        assertThat(byMatchCount).isEqualTo(WinningLottoType.FOURTH);
    }
}
