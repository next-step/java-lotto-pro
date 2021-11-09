package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {

    LottoShop lottoShop = new LottoShop();

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14"}, delimiter = ':')
    void 구입_가능한_로또_갯수_조회(int money, int expectResult) {
        // given
        Money purchaseMoney = new Money(money);

        // when
        int result = lottoShop.getPurchasableLottoTicketCount(purchaseMoney);

        // then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    void 구입_가능한_로또_갯수_조회_금액_부족() {
        // given
        int money = LottoShop.LOTTO_TICKET_PER_PRICE - 1;
        Money purchaseMoney = new Money(money);

        // when, then
        assertThatThrownBy(() -> lottoShop.getPurchasableLottoTicketCount(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 1장의 가격은 " + LottoShop.LOTTO_TICKET_PER_PRICE + "원 입니다. (입력값: " + money + ")");
    }
}