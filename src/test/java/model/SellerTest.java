package model;

import model.strategy.MockStrategy;
import model.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class SellerTest {

    @Test
    void 입력한_숫자만큼_자동으로_로또를_구매한다() {
        int count = 10;
        Seller seller = new Seller();
        List<LottoNumber> lottoNumbers = seller.buyAuto(count, new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottoNumbers).hasSize(count);
    }

    @Test
    void 수동으로_로또를_구매한다() {
        Seller seller = new Seller();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<LottoNumber> manualLotto = seller.buyManual(integers);

        assertThat(manualLotto).hasSize(1);
    }

    @Test
    void 로또숫자의범위는_1에서_45여야한다() {
        List<Integer> arrangeNumber = new ArrayList<>();
        int count = new Money(1000).availableBuyAutoLottoCount(0);

        for (int i = 1; i <= 45; i++) {
            arrangeNumber.add(i);
        }

        List<LottoNumber> autoLottoNumber = new Seller().buyAuto(1, new RandomStrategy(arrangeNumber));

        Lottos lottos = new Lottos(Collections.emptyList(), autoLottoNumber);

        for (LottoNumber lotto : lottos.getLotto()) {
            boolean result = lotto.getNumber().stream().allMatch(v -> v > 0 && v < 46);
            assertThat(result).isTrue();
        }
    }
}