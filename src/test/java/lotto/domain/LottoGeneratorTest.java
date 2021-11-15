package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void 로또_티켓_자동_발급() {
        // given
        int count = 3;
        PurchaseCount purchaseCount = new PurchaseCount(count);

        // when
        List<LottoTicket> autoLottoTickets = lottoGenerator.createAutoLottoTickets(purchaseCount);

        // then
        assertThat(autoLottoTickets.size()).isEqualTo(count);
    }

    @Test
    void 로또_티켓_수동_발급() {
        // given
        List<List<Integer>> manualNumbers = new ArrayList<>();
        manualNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        manualNumbers.add(Arrays.asList(7, 8, 9, 10, 11, 12));
        manualNumbers.add(Arrays.asList(13, 14, 15, 16, 17, 18));


        // when
        List<LottoTicket> manualLottoTickets = lottoGenerator.createManualLottoTickets(manualNumbers);

        // then
        assertThat(manualLottoTickets.size()).isEqualTo(manualNumbers.size());
    }
}