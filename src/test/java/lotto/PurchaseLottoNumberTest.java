package lotto;

import static lotto.Rank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseLottoNumberTest {
    private final List<LottoNumbers> fakePurchaseLottoNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        fakePurchaseLottoNumbers.add(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        fakePurchaseLottoNumbers.add(LottoNumbers.from(Arrays.asList(7, 8, 9, 10, 11, 12)));
    }

    @Test
    void 구매한_로또_번호_출력() {
        PurchaseLottoNumber purchaseLottoNumber = new PurchaseLottoNumber(fakePurchaseLottoNumbers);
        assertThat(purchaseLottoNumber.printPurchaseLottoNumber()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n");
    }

    @Test
    void 로또_등수_반환() {
        PurchaseLottoNumber purchaseLottoNumber = new PurchaseLottoNumber(fakePurchaseLottoNumbers);
        assertThat(purchaseLottoNumber.getRank(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 7)),
                LottoNumber.from(6)).get(0)).isEqualTo(SECOND);
    }
}
