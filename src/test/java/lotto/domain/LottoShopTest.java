package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {

    LottoShop lottoShop = new LottoShop();

    @ParameterizedTest
    @CsvSource(value = {"1000:0:1", "1000:1:0", "14000:4:10"}, delimiter = ':')
    void 구입_가능한_로또_갯수_조회(int money, int manualCount, int autoCount) {
        // when
        PurchaseCounts resultCounts = lottoShop.countPurchasableLotto(money, manualCount);

        // then
        assertThat(resultCounts).isEqualTo(new PurchaseCounts(new PurchaseCount(autoCount), new PurchaseCount(manualCount)));
    }

    @Test
    void 구입_가능한_로또_갯수_조회_금액_부족() {
        // given
        int purchaseMoney = LottoShop.LOTTO_TICKET_PER_PRICE - 1;
        int manualPurchaseCount = 1;

        // when, then
        assertThatThrownBy(() -> lottoShop.countPurchasableLotto(purchaseMoney, manualPurchaseCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 1장의 가격은 " + LottoShop.LOTTO_TICKET_PER_PRICE + "원 입니다. (입력값: " + purchaseMoney + ")");
    }

    @Test
    void 구입_가능한_로또_갯수_조회_수동_갯수_초과() {
        // given
        int purchaseMoney = 14000;
        int manualPurchaseCount = 15;

        // when, then
        assertThatThrownBy(() -> lottoShop.countPurchasableLotto(purchaseMoney, manualPurchaseCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수동 구매 갯수는 총 구매 가능 갯수보다 작거나 같아야 합니다. (입력값: " + manualPurchaseCount + ")");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    void 로또_발급(int count) {
        // given
        PurchaseCount purchaseCount = new PurchaseCount(count);

        // when
        List<LottoTicket> autoLottoTickets = lottoShop.createAutoLottoTickets(purchaseCount);

        // then
        assertThat(autoLottoTickets.size()).isEqualTo(count);
    }
}