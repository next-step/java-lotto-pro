package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("각 로또의 추첨 결과를 검증하는 테스트")
class LottosTest {

    private final WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");

    @Test
    void drawLots_추첨_테스트() {
        List<Lotto> allNumbersFromStore = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 11, 22, 33)),
                new Lotto(Arrays.asList(1, 2, 5, 6, 18, 19)));
        Lottos lottos = new Lottos(allNumbersFromStore);

        WinStats stats = lottos.drawLots(winningNumbers);
        Map<LottoStatus, Long> printData = stats.getPrintDataWithCountsByLottoStatus();

        assertAll(
                () -> assertEquals(1L, printData.get(LottoStatus.FOURTH_PLACE)),
                () -> assertEquals(1L, printData.get(LottoStatus.THIRD_PLACE)),
                () -> assertEquals("27.50", stats.getPrintDataWithProfitRate())
        );
    }
}
