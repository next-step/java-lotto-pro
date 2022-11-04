package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.domain.LottoWinningMoney.*;
import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {
    WinningLotto winningLotto;
    @BeforeEach
    void beforeEach(){
        winningLotto = WinningLotto.create(
                Lotto.create(Arrays.asList(5,15,25,35,45,30)), LottoNumber.create(10)
        );
    }

    @Test
    @DisplayName("5등 당첨 결과 저장하고 조회하기")
    void fifthResult(){
        LottoResult result = LottoResult.create();
        result.addLottoResult(winningLotto.getLottoRank(Lotto.create(Arrays.asList(1,10,15,20,25,30))));

        assertThat(result.getResultCount(FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("4등 당첨 결과 저장하고 조회하기")
    void fourthResult(){
        LottoResult result = LottoResult.create();
        result.addLottoResult(winningLotto.getLottoRank(Lotto.create(Arrays.asList(5,10,15,20,25,30))));

        assertThat(result.getResultCount(FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("3등 당첨 결과 저장하고 조회하기")
    void thirdResult(){
        LottoResult result = LottoResult.create();
        result.addLottoResult(winningLotto.getLottoRank(Lotto.create(Arrays.asList(5,45,15,20,25,30))));

        assertThat(result.getResultCount(THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등 당첨 결과 저장하고 조회하기")
    void secondResult(){
        LottoResult result = LottoResult.create();
        result.addLottoResult(winningLotto.getLottoRank(Lotto.create(Arrays.asList(35,45,30,10,15,25))));

        assertThat(result.getResultCount(SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("1등 당첨 결과 저장하고 조회하기")
    void firstResult(){
        LottoResult result = LottoResult.create();
        result.addLottoResult(winningLotto.getLottoRank(Lotto.create(Arrays.asList(35,45,30,5,15,25))));

        assertThat(result.getResultCount(FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("0,1,2 개 당첨 결과는 MISS 로 처리한다.")
    void noResultTest(){
        Lotto buy0 = Lotto.create(Arrays.asList(34,44,29,4,14,24));
        Lotto buy1 = Lotto.create(Arrays.asList(34,45,29,4,14,24));
        Lotto buy2 = Lotto.create(Arrays.asList(34,45,29,4,15,24));

        LottoResult result = LottoResult.create();
        result.addLottoResult(winningLotto.getLottoRank(buy0));
        result.addLottoResult(winningLotto.getLottoRank(buy1));
        result.addLottoResult(winningLotto.getLottoRank(buy2));

        assertThat(result.getResultCount(MISS)).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨금을 계산한다.")
    void calculateMoney(){
        LottoResult result = LottoResult.create();

        result.addLottoResult(winningLotto.getLottoRank(Lotto.create(Arrays.asList(5,15,25,35,45,10)))); // 2등
        result.addLottoResult(winningLotto.getLottoRank(Lotto.create(Arrays.asList(5,15,25,35,45,11)))); // 3등
        result.addLottoResult(winningLotto.getLottoRank(Lotto.create(Arrays.asList(5,15,25,36,44,11)))); // 5등

        assertThat(result.calculateWinningMoney()).isEqualTo(4505000);
    }
}
