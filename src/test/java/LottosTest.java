import model.LottoNumber;
import model.LottoRankType;
import model.Lottos;
import model.Money;
import model.strategy.MockStrategy;
import model.strategy.RandomStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static model.LottoRankType.RANK_THREE;
import static model.LottoRankType.RANK_TWO;
import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @Test
    void 입력한_금액만큼_로또를구매한다() {
        int count = new Money(10000).availableBuyAutoLottoCount(0);
        Lottos lottos = new Lottos(count, Collections.emptyList(), new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottos.getLotto()).hasSize(10);
    }

    @Test
    void 로또숫자의범위는_1에서_45여야한다() {
        List<Integer> arrangeNumber = new ArrayList<>();
        int count = new Money(1000).availableBuyAutoLottoCount(0);

        for (int i = 1; i <= 45; i++) {
            arrangeNumber.add(i);
        }

        Lottos lottos = new Lottos(count, Collections.emptyList(), new RandomStrategy(arrangeNumber));

        for (LottoNumber lotto : lottos.getLotto()) {
            boolean result = lotto.getNumber().stream().allMatch(v -> v > 0 && v < 46);
            assertThat(result).isTrue();
        }
    }

    @Test
    void 로또의_순위리스트를_받는다() {
        int count = new Money(1000).availableBuyAutoLottoCount(0);

        Lottos lottos = new Lottos(count, Collections.emptyList(), new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 9);
        int bonusNumber = 40;

        List<LottoRankType> result = lottos.getLottoRank(winNumber, bonusNumber);

        assertThat(result.get(0)).isEqualTo(RANK_THREE);
    }

    @Test
    void 숫자가5개와_보너스넘버까지_일치하면_2등으로_판별한다() {
        int count = new Money(1000).availableBuyAutoLottoCount(0);

        Lottos lottos = new Lottos(count, Collections.emptyList(), new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 9);
        int bonusNumber = 6;

        List<LottoRankType> result = lottos.getLottoRank(winNumber, bonusNumber);

        assertThat(result.get(0)).isEqualTo(RANK_TWO);
    }

    @Test
    void 숫자가5개는_일치하지만_보너스넘버가_일치하지않으면_3등으로_판별한다() {
        int count = new Money(1000).availableBuyAutoLottoCount(0);
        Lottos lottos = new Lottos(count, Collections.emptyList(), new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 9);
        int bonusNumber = 45;

        List<LottoRankType> result = lottos.getLottoRank(winNumber, bonusNumber);

        assertThat(result.get(0)).isEqualTo(RANK_THREE);
    }

    @Test
    void 수동으로만_로또를_구매한다() {
        List<LottoNumber> manualLotto = new ArrayList<>();
        manualLotto.add(new LottoNumber(Arrays.asList(1,2,3,4,5,6)));

        Lottos lottos = new Lottos(0, manualLotto, new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(lottos.getLotto()).hasSize(1);
    }

    @Test
    void 자동으로만_로또를_구매한다() {
        int autoCount = 10;

        Lottos lottos = new Lottos(autoCount, Collections.emptyList(), new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(lottos.getLotto()).hasSize(autoCount);
    }


    @Test
    void 수동_자동_을_섞어서_로또를_구매한다() {
        List<LottoNumber> manualLotto = new ArrayList<>();
        manualLotto.add(new LottoNumber(Arrays.asList(1,2,3,4,5,6)));

        Lottos lottos = new Lottos(3, manualLotto, new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(lottos.getLotto()).hasSize(4);
    }

}
