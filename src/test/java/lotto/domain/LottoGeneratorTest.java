package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void 로또_티켓_발급() {
        // given
        int count = 3;
        PurchaseCount purchaseCount = new PurchaseCount(count);

        // when
        List<LottoTicket> lottoTickets = lottoGenerator.createLottoTickets(purchaseCount);

        // then
        assertThat(lottoTickets.size()).isEqualTo(count);
    }
}