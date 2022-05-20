package study.lotto.domain.lottomachine;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.Lotto;
import study.lotto.domain.Lottos;

public class LottoPurchaseHistoryTest {
    private LottoPurchaseHistory purchaseHistory;

    @BeforeEach
    void setUp() {
        Lottos lottos = new Lottos(fixturesLotto());
        purchaseHistory = new LottoPurchaseHistory(lottos, new LottoCount(2), new BigDecimal(5000));
    }

    @Test
    @DisplayName("수동 로또 개수를 반환할 수 있다.")
    void 수동_로또_개수() {
        assertThat(purchaseHistory.getManualCount()).isEqualTo(new LottoCount(2));
    }

    @Test
    @DisplayName("자동 로또 개수를 반환할 수 있다.")
    void 자동_로또_개수() {
        assertThat(purchaseHistory.getAutomaticLottoCount()).isEqualTo(new LottoCount(3));
    }

    private List<Lotto> fixturesLotto() {
        return Arrays.asList(
                Lotto.from(Arrays.asList(8, 21, 23, 41, 42, 43)),
                Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 38)),
                Lotto.from(Arrays.asList(7, 11, 16, 35, 36, 44)),
                Lotto.from(Arrays.asList(13, 14, 16, 38, 42, 45)),
                Lotto.from(Arrays.asList(1, 3, 5, 14, 22, 45)));
    }
}
