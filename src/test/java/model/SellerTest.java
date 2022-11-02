package model;

import model.strategy.MockStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        List<LottoNumber> number = new ArrayList<>();
        number.add(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5)));

        seller.buyManual(number);

        assertThat(number).hasSize(1);
    }
}