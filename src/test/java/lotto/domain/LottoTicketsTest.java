package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    private LottoTickets tickets;

    @BeforeEach
    void before() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumbers.from(() -> Arrays.asList(1,2,3,4,5,6)));
        lottoNumbers.add(LottoNumbers.from(() -> Arrays.asList(11,22,33,44,5,6)));
        tickets = LottoTickets.from(lottoNumbers);
    }

    @Test
    void 구입한_티켓들_에서_당첨_금액을를_알수_있다() {
        LottoWinningResults results = tickets.match(LottoNumbers.from(() -> Arrays.asList(7,8,9,10,11,45)));
        double prizedMoney = results.prizedMoney();
        assertThat(prizedMoney).isEqualTo(0);
    }

    @Test
    void 순위별_개수를_구할수_있다() {
        LottoWinningResults results = tickets.match(LottoNumbers.from(() -> Arrays.asList(1,2,3,11,22,33)));
        assertThat(results.winingRankCount(LottoRank.FOURTH)).isEqualTo(2);
    }
}
