package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PurchasedLottoTicketsTest {

    private PurchasedLottoTickets tickets;

    @BeforeEach
    void before() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumbers.from(Arrays.asList(1,2,3,4,5,6)));
        lottoNumbers.add(LottoNumbers.from(Arrays.asList(11,22,33,44,5,6)));
        tickets = PurchasedLottoTickets.from(lottoNumbers);
    }

    @Test
    void 구입한_티켓의_번호를_출력() {
        String string = tickets.toString();
        assertThat(string).
                contains("[1, 2, 3, 4, 5, 6]").
                contains("[11, 22, 33, 44, 5, 6]");
    }

    @Test
    void 구입한_티켓들을_이용하여_우승로또와_비교() {
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 7)), LottoNumber.from(6));
        LottoWinningResults results = tickets.checkWinningLotto(winningLotto);
        assertThat(results.prizedMoney()).isEqualTo(30_000_000);
    }
}
