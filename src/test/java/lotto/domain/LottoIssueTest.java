package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIssueTest {

    @Test
    public void 로또를_자동으로_5장_발급한다() {
        //given
        int purchaseQuantity = 5;

        //when
        LottoTicket lottoTicket = LottoIssue.ofAuto(purchaseQuantity);

        //then
        assertThat(lottoTicket.getLottoTicket().size()).isEqualTo(purchaseQuantity);
    }

}