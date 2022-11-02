package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("로또 결과 테스트")
class LottoResultTest {

    private WinningLottoNumbers winningLottoNumbers;

    @BeforeEach
    void init() {
        winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,6", 7);
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

        Assertions.assertThat(lottoResult.lottoProfitPercent(4000)).isEqualTo(2.5);
    }

}