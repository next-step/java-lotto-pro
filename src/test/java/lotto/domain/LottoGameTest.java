package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("로또 게임 테스트")
class LottoGameTest {

    @DisplayName("정해진 금액에서 수동 구매후 나머지는 모두 자동을 구매한다.")
    @Test
    void manual_purchase_after_auto_purchase() {
        List<LottoGenerator> lottoGeneratorList = new ArrayList<>(
                Arrays.asList(
                    new ManualLottoGenerator("1,2,3,4,5,6"),
                    new ManualLottoGenerator("1,2,3,4,5,6"),
                    new ManualLottoGenerator("1,2,3,4,5,6")
                )
        );
        LottoGame lottoGame = new LottoGame();

        LottoTickets lottoTickets = lottoGame.buy(new LottoMoney("10000"), lottoGeneratorList);
        Assertions.assertThat(lottoTickets.ticketCount()).isEqualTo(10);

        lottoTickets = lottoGame.buy(new LottoMoney("3000"), lottoGeneratorList);
        Assertions.assertThat(lottoTickets.ticketCount()).isEqualTo(3);
    }

}