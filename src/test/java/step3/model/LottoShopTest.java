package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShopTest {

    @Test
    @DisplayName("수동생성 수량과 자동생성 수량의 합이 구매수량의 총 수와 일치한다.")
    void create_lotto_paper_test() {
        Money money = new Money(3000);
        List<LottoGenerator> lottoGenerators = new ArrayList<>(Arrays.asList(new LottoCustomGenerator(Arrays.asList(1, 5, 11, 19, 36, 40))));

        LottoShop lottoShop = new LottoShop();
        LottoPaper lottoPaper = lottoShop.buyLotto(money, lottoGenerators);

        assertThat(lottoPaper.getLottos().size()).isEqualTo(money.countOfLottoPurchases());
    }
}
