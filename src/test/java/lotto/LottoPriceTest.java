package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoPriceTest {

    @Test
    void 로또는_1000원_단위로만_구매할_수_있다() {
        new LottoPrice(1000);
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LottoPrice(950));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2"})
    void 로또_구입금액으로_로또_구매개수를_구할_수_있다(Integer price, Integer count) {
        assertThat(new LottoPrice(price).getCount()).isEqualTo(count);
    }

}