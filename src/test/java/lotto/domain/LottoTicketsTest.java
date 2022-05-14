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
    void 당첨된_등급의_리스트를_얻을수_있다() {
        List<LottoRank> lottoRanks = tickets.match(LottoNumbers.from(() -> Arrays.asList(7, 8, 9, 10, 11, 45)));
        assertThat(lottoRanks).hasSize(0);
    }

    @Test
    void 구입한_티켓의_번호를_출력() {
        String string = tickets.toString();
        assertThat(string).
                contains("[1, 2, 3, 4, 5, 6]").
                contains("[11, 22, 33, 44, 5, 6]");
    }
}
