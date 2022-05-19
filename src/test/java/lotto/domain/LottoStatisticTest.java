package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoStatisticTest {

    private LottoStatistic lottoStatistic;

    @BeforeEach
    void setUp() {

        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};

        int[] notWinningNumbers = {7, 8, 9, 19, 20, 21};
        int[] threeWinningNumbers = {1, 2, 3, 7, 8, 9};

        List<Lotto> lottoList = createNotWinningLottos(notWinningNumbers, 9);
        lottoList.add(createLotto(threeWinningNumbers));

        lottoStatistic = new LottoStatistic(Lottos.from(lottoList), winningNumbers);
    }


    @Test
    void 수익률_계산() {
        assertThat(lottoStatistic.lottoEarning()).isEqualTo(BigDecimal.valueOf(0.5));
    }

    @Test
    void 셋업에_맞는_담청_결과를_반환() {

        Map<MatchResult, Integer> winingResult = lottoStatistic.winningMatchResultCount();

        assertThat(winingResult.get(MatchResult.FIFTH)).isEqualTo(1);
        assertThat(winingResult.get(MatchResult.SIXTH)).isEqualTo(0);
        assertThat(winingResult.get(MatchResult.SEVENTH)).isEqualTo(0);
        assertThat(winingResult.get(MatchResult.EIGHTH)).isEqualTo(0);
    }

    private List<Lotto> createNotWinningLottos(int[] notWinningNumbers, int size) {
        List<Lotto> result = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            result.add(createLotto(notWinningNumbers));
        }
        return result;
    }

    private Lotto createLotto(int[] inputs) {
        LottoNumber[] lottoNumbers = new LottoNumber[inputs.length];

        for (int index = 0; index < inputs.length; index++) {
            lottoNumbers[index] = LottoNumber.from(inputs[index]);
        }

        return new Lotto(lottoNumbers);
    }
}