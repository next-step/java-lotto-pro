package lotto.domain;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

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
    @DisplayName("상금 액수가 정상적으로 계산되어야 한다.")
    void 로또상금_계산_테스트(){
        // given
        LottoResult lottoResult = lottoGame.getLottoResult(new LottoLine("1, 17, 23, 35, 39, 45"), new LottoNumber(45));

        // when
        int expectedPrize = lottoResult.getLottoPrize();

        // then
        Assertions.assertThat(expectedPrize).isEqualTo(30_005_000);
    }
}