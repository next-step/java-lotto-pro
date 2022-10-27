package lotto.ticket;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketsTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,10})
    void 로또_티켓_목록을_생성한다(int quantity){
        LottoTickets lottoTickets = new LottoTickets(quantity);
        int result = lottoTickets.getQuantity();
        assertThat(result).isEqualTo(quantity);
    }

}
