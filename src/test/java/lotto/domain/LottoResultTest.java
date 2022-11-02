package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 결과 테스트")
class LottoResultTest {

    private WinningLottoNumbers winningLottoNumbers;

    @BeforeEach
    void init() {
        winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,6", new LottoNumber(7));
    }

    @DisplayName("로또 결과 수익률 확인")
    @Test
    void lotto_result_profit() {

        List<LottoGenerator> lottoGeneratorList = new ArrayList<>(
                Arrays.asList(
                        new ManualLottoGenerator("1,2,3,10,11,12"),
                        new ManualLottoGenerator("1,2,3,10,11,12")
                )
        );

        LottoGame lottoGame = new LottoGame();
        LottoTickets lottoTickets = lottoGame.buy(new LottoMoney("4000"), lottoGeneratorList);

        LottoResult lottoResult = new LottoResult();
        lottoTickets.lottoWinningConfirm(winningLottoNumbers, lottoResult);

        assertThat(lottoResult.lottoProfitPercent(4000)).isEqualTo(2.5);
    }

}