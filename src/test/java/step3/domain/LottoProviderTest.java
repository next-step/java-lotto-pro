package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoProviderTest {
    LottoProvider lottoProvider;

    @ParameterizedTest
    @CsvSource(value = {"5000:5", "1000:1", "500:0"}, delimiter = ':')
    @DisplayName("지불할 금액으로 로또 구매가능 수량 검증")
    void 구매가능_수량계산_Of_지불금액(int purchaseCost, int expected) {
        // given
        lottoProvider = new LottoProvider(purchaseCost);

        // when, then
        assertThat(lottoProvider.availableQuantity()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:5000", "1:1000", "0:0"}, delimiter = ':')
    @DisplayName("구매수량과 정해진 로또 가격을 계산하여 총 결제금액을 검증")
    void 구매수량_입력_총결제금액(int buyQuantity, int purchaseCost) {
        // when
        lottoProvider = new LottoProvider(purchaseCost);

        // then
        assertThat(lottoProvider.totalPurchasePrice(buyQuantity)).isEqualTo(purchaseCost);
    }

    @ParameterizedTest
    @CsvSource(value = {"5000:5", "1000:1"}, delimiter = ':')
    @DisplayName("LottoTicker 지불 금액에 맞추어 LottoTicket 구매 갯수 검증")
    void 지불금액_구매된_LottoTicker_카운트_검증(int purchaseCost, int expected) {

        // when
        lottoProvider = new LottoProvider(purchaseCost);
        List<List<Integer>> unmodifiableLottoTicketBundle = lottoProvider.buyLotto();

        // then
        assertThat(unmodifiableLottoTicketBundle.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5000", "1000"})
    @DisplayName("LottoProvider 에 의해 발급된 LottoTicker 은 변경 불가 검증")
    void 구매후_LottoTicket_변조_불가_검증(int purchaseCost) {
        // when
        lottoProvider = new LottoProvider(purchaseCost);
        List<List<Integer>> unmodifiableLottoTicketBundle = lottoProvider.buyLotto();

        // then
        assertThatThrownBy(() -> {
            unmodifiableLottoTicketBundle.get(0).add(5);
        })
            // then
            .isInstanceOf(UnsupportedOperationException.class);
    }

}
