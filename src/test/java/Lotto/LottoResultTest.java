package Lotto;

import Lotto.enums.CompareEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void init() {
        lottoResult = new LottoResult();
        lottoResult.counting(CompareEnum.First);
        lottoResult.counting(CompareEnum.Third);
    }

    @Test
    void 결과_수익_계산() {
        lottoResult.calculationYield(new PurchaseMoney(10000));
        assertThat(lottoResult.getYield().getInvestment()).isEqualTo(10000);
        assertThat(lottoResult.getYield().getYield()).isEqualTo((double) (2_000_000_000 + 50_000) / 10000);
    }
}
