package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

@DisplayName("로또 결과 테스트")
class LottoResultTest {

    private LottoTickets lottoTickets;
    private WinningLottoNumbers winningLottoNumbers;

    @BeforeEach
    void init() {
        lottoTickets = new LottoTickets(new ArrayList<>(
                Arrays.asList(
                        new LottoTicket(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)))
                )
        ));
        winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,6", new LottoNumber(10));
    }

    @DisplayName("당첨자의 이익률을 알 수 있다.")
    @Test
    void number_of_1st_place_winners() {
        LottoResult lottoResult = new LottoResult();
        lottoTickets.matchLottoResult(winningLottoNumbers, lottoResult);
        Assertions.assertThat(lottoResult.lottoProfitPercent(lottoTickets.ticketListPrice())).isEqualTo(2000000.0);
    }

}