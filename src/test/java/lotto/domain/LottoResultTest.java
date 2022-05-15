package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    @DisplayName("구입 금액과 당첨 결과를 파라미터로 LottoResult 객체가 생성되어야 한다")
    void create() {
        // given
        final LottoPayment lottoPayment = new LottoPayment("10000");
        final LottoTickets lottoTickets = new LottoTickets(lottoPayment.getPurchasableAmount());
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        final LottoResult lottoResult = new LottoResult(lottoPayment.getMoney(), lottoTickets.prizeMap(winningNumbers));
        lottoResult.printResult();

        // then
        assertThat(lottoResult).isInstanceOf(LottoResult.class);
        assertThat(lottoResult).isEqualTo(new LottoResult(lottoPayment.getMoney(), lottoTickets.prizeMap(winningNumbers)));
    }

}
