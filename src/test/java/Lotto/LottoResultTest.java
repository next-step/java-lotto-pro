package Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void init() {
        lottoResult = new LottoResult(1, 2, 0, 3);
    }

    @Test
    void 결과_수익_계산() {
        lottoResult.calculationYield(new PurchaseMoney(10000));
        assertThat(lottoResult.getYield().getSumMoney()).isEqualTo(new BigDecimal(2003015000));
        assertThat(lottoResult.getYield().getYield()).isEqualTo((double) 2003015000 / 10000);
    }
}
