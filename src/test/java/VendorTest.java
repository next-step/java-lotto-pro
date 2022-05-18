import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VendorTest {
    @Test
    void 로또를_구매할_수_있다() {
        assertThat(new Vendor().buy(Vendor.LOTTO_PRICE)).isInstanceOf(Lotto.class);
    }

    @Test
    void 가격_미만이면_로또를_구매할_수_없다() {
        assertThatThrownBy(() -> new Vendor().buy(Vendor.LOTTO_PRICE - 1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 수익률을_계산할_수_있다() {
        Ranks ranks = new Ranks();
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.FIFTH);

        BigDecimal yield = new Vendor().yield(ranks);
        assertThat(yield.setScale(2, RoundingMode.DOWN).doubleValue()).isEqualTo(0.35);
    }
}
