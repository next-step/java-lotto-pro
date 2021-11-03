package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoProviderTest {

    @ParameterizedTest
    @CsvSource(value = {"5000:5", "1000:1", "500:0"}, delimiter = ':')
    @DisplayName("지불할 금액으로 로또 구매가능 수량 검증")
    void 구매가능_수량계산_Of_지불금액(int purchaseCost, int expected) {
        assertThat(LottoProvider.availableQuantity(purchaseCost)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:5000", "1:1000", "0:0"}, delimiter = ':')
    @DisplayName("구매수량과 정해진 로또 가격을 계산하여 총 결제금액을 검증")
    void 구매수량_입력_총결제금액(int buyQuantity, int expected) {
        assertThat(LottoProvider.totalPurchasePrice(buyQuantity)).isEqualTo(expected);
    }

}
