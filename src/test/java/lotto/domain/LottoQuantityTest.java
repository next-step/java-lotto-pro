package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoQuantityTest {
    @Test
    @DisplayName("로또 갯수 생성")
    void lotto_quantity() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("10000");
        LottoQuantity lottoQuantity = LottoQuantity.of(lottoPurchaseAmount.getQuantity());
        assertThat(lottoQuantity).isEqualTo(LottoQuantity.of(10));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "3000:3", "10000:10", "15000:15"}, delimiter = ':')
    @DisplayName("구매 갯수 출력")
    void print_lotto_quantity(String input, int expect) {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(input);
        LottoQuantity lottoQuantity = LottoQuantity.of(lottoPurchaseAmount.getQuantity());
        assertThat(lottoQuantity.print()).isEqualTo(String.format(LottoQuantity.PRINT_QUANTITY_FORMAT, expect));
    }
}