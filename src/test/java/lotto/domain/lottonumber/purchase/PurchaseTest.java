package lotto.domain.lottonumber.purchase;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lottonumber.purchase.factory.PurchaseFactoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseTest {

    @ParameterizedTest
    @DisplayName("구매금액과 이윤으로 총 수익률 계산")
    @CsvSource(value = {"1000:1000:1.00", "1000:10000:10.00", "1000:0:0.00",
            "1000:0:기준이 1이기 때문에 결과적으로 손해라는 의미임"}, delimiter = ':')
    void profitMargin(String purchase, int totalProfit, String expected) {
        Purchase makePurchase = new PurchaseFactoryImpl(purchase).createPurchase();
        assertThat(makePurchase.makeProfitMargin(totalProfit)).contains(expected);
    }

    @ParameterizedTest
    @DisplayName("로또가격 으로 나눈 수 만큼 로또번호 갯수 생성")
    @CsvSource(value = {"1000:1", "12000:12", "25000:25"}, delimiter = ':')
    void makeLottoNumberCount(String purchase, int expected) {
        Purchase makePurchase = new PurchaseFactoryImpl(purchase).createPurchase();
        assertThat(makePurchase.makeLottoNumberCount()).isEqualTo(expected);
    }
}
