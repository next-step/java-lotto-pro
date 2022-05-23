package step3.lotto.domain.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static step3.lotto.domain.customer.Customer.INVALID_MANUAL_LOTTOS_SIZE_ERROR;
import static step3.lotto.utils.LottoNumberUtils.generateLottoNumbers;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.lotto.domain.customer.wrap.ManualAttemptsCount;
import step3.lotto.domain.customer.wrap.Price;
import step3.lotto.domain.lotto.Lotto;
import step3.lotto.domain.lotto.Lottos;

/**
 * @author : choi-ys
 * @date : 2022/05/17 2:04 오후
 */
@DisplayName("Domain:Customer")
class CustomerTest {

    @Test
    @DisplayName("구매 금액과 수동 로또 구매 횟수를 이용한 사용자 도메인 생성 여부 검증")
    public void createCustomerTest() {
        // Given
        final Price price = Price.of(15_000);
        final ManualAttemptsCount manualAttemptsCount = ManualAttemptsCount.of(5, price);
        Lottos manualLottos = new Lottos(Arrays.asList(
            Lotto.of(generateLottoNumbers()),
            Lotto.of(generateLottoNumbers()),
            Lotto.of(generateLottoNumbers()),
            Lotto.of(generateLottoNumbers()),
            Lotto.of(generateLottoNumbers())
        ));

        // When
        Customer actual = Customer.of(price, manualAttemptsCount, manualLottos);

        // Then
        assertAll(
            () -> assertThat(actual).isNotNull(),
            () -> assertThat(actual.getTotalAttemptsCount()).as("전체 로또 구매 횟수").isEqualTo(15),
            () -> assertThat(actual.getAutoAttemptsCount()).as("자동 로또 구매 횟수").isEqualTo(10),
            () -> assertThat(actual.getManualAttemptsCount()).as("수동 로또 구매 횟수").isEqualTo(5),
            () -> assertThat(actual.getLottosSize()).as("전체 로또 게임 수").isEqualTo(15)
        );
    }

    @Test
    @DisplayName("수동 로또 구매 횟수와 수동 로또 게임 수가 일치 하지 않는 경우")
    public void throwException_WhenInvalidManualLottosSize() {
        // Given
        final Price price = Price.of(15_000);
        final ManualAttemptsCount manualAttemptsCount = ManualAttemptsCount.of(5, price);
        final Lottos manualLottos = new Lottos(Collections.emptyList());

        // When & THen
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Customer.of(price, manualAttemptsCount, manualLottos))
            .withMessageMatching(INVALID_MANUAL_LOTTOS_SIZE_ERROR);
    }
}
