package lotto.domain;

import java.util.Arrays;
import lotto.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    LottoGame lottoGame;

    @BeforeEach
    void 초기화(){
        lottoGame = new LottoGame(
            Arrays.asList(
                new LottoLine("1, 2, 3, 4, 5, 6"),
                new LottoLine("4, 12, 23, 34, 41, 45"),
                new LottoLine("1, 15, 18, 24, 35, 39"),
                new LottoLine("11, 17, 28, 32, 43, 45"),
                new LottoLine("3, 7, 23, 24, 29, 36"),
                new LottoLine("1, 22, 23, 35, 39, 45")
            )
        );
    }

    @Test
    @DisplayName("주어진 개수만큼 로또가 생성되어야 한다.")
    void 로또게임_생성_테스트(){
        LottoGame lottoGameByCount = LottoGame.issueLotto(14);
        Assertions.assertThat(lottoGameByCount.toLottoGameDTO().size()).isEqualTo(14);
    }

    @Test
    @DisplayName("생성된 로또 문자열이 정상적으로 출력되어야 한다.")
    void 로또게임_출력_테스트(){
        OutputView outputView = new OutputView();
        Assertions.assertThat(outputView.getLottoGameString(lottoGame.toLottoGameDTO()))
            .isEqualTo(
                "[1, 2, 3, 4, 5, 6]\n"
                + "[4, 12, 23, 34, 41, 45]\n"
                + "[1, 15, 18, 24, 35, 39]\n"
                + "[11, 17, 28, 32, 43, 45]\n"
                + "[3, 7, 23, 24, 29, 36]\n"
                + "[1, 22, 23, 35, 39, 45]"
            );
    }

    @Test
    @DisplayName("로또 통계 문자열이 정상적으로 출력되어야 한다.")
    void 로또게임_결과_테스트(){
        OutputView outputView = new OutputView();
        LottoResult lottoResult = lottoGame.getLottoResult(new LottoLine("1, 17, 23, 35, 39, 45"));
        Assertions.assertThat(outputView.getLottoResultString(lottoResult))
            .isEqualTo(
                "3개 일치 (5000원)- 1개\n"
                + "4개 일치 (50000원)- 0개\n"
                + "5개 일치 (1500000원)- 1개\n"
                + "6개 일치 (2000000000원)- 0개\n"
        );
    }

    @Test
    @DisplayName("생성된 로또 수익률 문자열이 정상적으로 출력되어야 한다.")
    void 로또게임_수익률_테스트(){
        OutputView outputView = new OutputView();
        LottoResult lottoResult = lottoGame.getLottoResult(new LottoLine("1, 17, 23, 35, 39, 45"));
        LottoPayment payment = new LottoPayment(14000);
        LottoPayment prize = new LottoPayment(lottoResult.getLottoPrize());
        Assertions.assertThat(outputView.getEarningRateString(payment.toLottoPaymentDTO(), prize.toLottoPaymentDTO()))
            .isEqualTo(
                "총 수익률은 107.5입니다."
            );
    }
}