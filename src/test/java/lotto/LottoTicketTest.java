package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketTest {

    @ParameterizedTest(name = "입력받은 금액({0})에 따른 {1}개의 로또가 생성되어 반환")
    @CsvSource(value = {"1500:1", "20000:20", "35100:35"}, delimiter = ':')
    void getLottoNumber(String money, int expected) {
        LottoPurchaseQuantity lottoPurchaseQuantity = new LottoPurchaseQuantity(money);
        LottoTicket lottoTickets = new LottoTicket(lottoPurchaseQuantity);
        List<LottoNumberInterface> lottoNumbers = lottoTickets.getLottoNumbers();

        assertAll(
                () -> assertThat(lottoNumbers).isNotNull(),
                () -> assertThat(lottoNumbers).hasSize(expected)
        );

    }
}
