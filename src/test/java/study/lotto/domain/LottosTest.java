package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.order.Order;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("각 로또의 추첨 결과를 검증하는 테스트")
class LottosTest {

    private final WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");

    @Test
    void drawLots_추첨_테스트() {
        Order order = new Order("2000");
        order.addManualQuantity(2);
        order.addManualLotto("1, 2, 3, 11, 22, 33");
        order.addManualLotto("1, 2, 3, 4, 22, 33");

        Lottos lottos = Store.buyLottos(order);

        WinStats stats = lottos.drawLots(winningLotto);
        Map<LottoStatus, Long> printData = stats.countsByLottoStatus();

        assertAll(
                () -> assertEquals(1L, printData.get(LottoStatus.FIFTH_PLACE)),
                () -> assertEquals(1L, printData.get(LottoStatus.FOURTH_PLACE)),
                () -> assertEquals("27.50", stats.getProfitRate())
        );
    }

    @Test
    void orderType별_로또_개수를_구한다() {
        Order order = new Order("5000");
        order.addManualQuantity(2);
        order.addManualLotto("1, 2, 3, 11, 22, 33");
        order.addManualLotto("1, 2, 3, 4, 22, 33");

        Lottos lottos = Store.buyLottos(order);

        assertEquals("2,3", lottos.countByOrderType());
    }
}
