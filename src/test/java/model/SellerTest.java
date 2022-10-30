package model;

import model.strategy.MockStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SellerTest {

    @Test
    void 입력한_숫자만큼_로또를_구매한다() {
        int count = 10;

        List<LottoNumber> result = new Seller().buy(count, new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(result).hasSize(count);
    }
}