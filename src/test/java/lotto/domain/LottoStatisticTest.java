package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoStatisticTest {

    private int NUMBER_COUNT = 6;
    private Money orderMoney;

    private LottoStatistic lottoStatistic;

    @BeforeEach
    void setUp() {

        orderMoney = Money.from(10000);

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(createLotto(7, 8, 9, 19, 20, 21));
        lottoList.add(createLotto(7, 8, 9, 19, 20, 21));
        lottoList.add(createLotto(7, 8, 9, 19, 20, 21));
        lottoList.add(createLotto(7, 8, 9, 19, 20, 21));
        lottoList.add(createLotto(7, 8, 9, 19, 20, 21));
        lottoList.add(createLotto(7, 8, 9, 19, 20, 21));
        lottoList.add(createLotto(7, 8, 9, 19, 20, 21));
        lottoList.add(createLotto(7, 8, 9, 19, 20, 21));
        lottoList.add(createLotto(7, 8, 9, 19, 20, 21));
        lottoList.add(createLotto(1, 2, 3, 7, 8, 9));

        Lottos lottos = Lottos.from(lottoList);

        List<LottoNumber> prizeNumbers = new ArrayList<>();
        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};

        lottoStatistic = new LottoStatistic(lottos, winningNumbers);
    }


    @Test
    void 수익률() {
        assertThat(lottoStatistic.lottoEarning()).isEqualTo(BigDecimal.valueOf(0.5));
    }

    @Test
    void 담청_결과() {
        assertThat(lottoStatistic.matchedCount(MatchResult.THREE)).isEqualTo(1);
        assertThat(lottoStatistic.matchedCount(MatchResult.FOUR)).isEqualTo(0);
        assertThat(lottoStatistic.matchedCount(MatchResult.FIVE)).isEqualTo(0);
        assertThat(lottoStatistic.matchedCount(MatchResult.SIX)).isEqualTo(0);
    }


    private Lotto createLotto(int input0, int input1, int input2, int input3, int input4, int input5) {
        LottoNumber[] lottoNumbers = new LottoNumber[NUMBER_COUNT];
        lottoNumbers[0] = LottoNumber.from(input0);
        lottoNumbers[1] = LottoNumber.from(input1);
        lottoNumbers[2] = LottoNumber.from(input2);
        lottoNumbers[3] = LottoNumber.from(input3);
        lottoNumbers[4] = LottoNumber.from(input4);
        lottoNumbers[5] = LottoNumber.from(input5);

        return new Lotto(lottoNumbers);
    }
}