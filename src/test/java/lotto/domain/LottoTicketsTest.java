package lotto.domain;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("다량의 로또 티켓 테스트")
class LottoTicketsTest {

    private LottoTickets lottoTickets;
    private WinningLottoNumbers winningLottoNumbers;

    @BeforeEach
    void init() {
        lottoTickets = new LottoTickets(new ArrayList<>(
                Arrays.asList(
                        new LottoTicket(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        new LottoTicket(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        new LottoTicket(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        new LottoTicket(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        new LottoTicket(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 8)))
                )
        ));
        winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,6", 10);
    }

    @DisplayName("고정된 당첨금과 로또번호로 당첨 사실을 알 수 있다.")
    @Test
    void lotto_number_know_you_win() {
        LottoResult lottoResult = new LottoResult();
        lottoTickets.lottoWinningConfirm(winningLottoNumbers, lottoResult);
        assertThat(lottoResult.getLottoResultMap().get(LottoRank.FIRST)).isEqualTo(4);
        assertThat(lottoResult.getLottoResultMap().get(LottoRank.THIRD)).isEqualTo(1);
    }

}