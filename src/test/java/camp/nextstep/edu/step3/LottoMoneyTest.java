package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.step3.LottoTest.createLottoNumberList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoMoneyTest {
    @DisplayName("정수 값을 입력해야된다.")
    @Test
    void createTest() {
        assertThat(new LottoMoney(0)).isEqualTo(new LottoMoney(0));
    }

    @DisplayName("잘못된 값 입력시 RuntimeException 을 발생한다.")
    @Test
    void invalidInputTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoMoney(-1));
    }

    @DisplayName("로또 가격은 1000이면 1000원 이상 이면 로또를 살수 있다.")
    @Test
    void isBuyableTest() {
        assertThat(new LottoMoney(1000).isBuyable()).isTrue();
    }

    @DisplayName("로또 구매시 로또 금액을 제외한 나머지 금액을 반환한다.")
    @Test
    void buyTest() {
        LottoMoney thousand = new LottoMoney(1000);
        assertThat(thousand.buy()).isEqualTo(new LottoMoney(0));
    }

    @DisplayName("로또 금액에 총상금정보를 입력하면 총수익률을 반환한다.")
    @Test
    void calculateTest() {
        assertThat(new LottoMoney(14000).calculate(5000)).isEqualTo(new EarningsRate(0.35));
    }

    @DisplayName("구입 금액이 0원 인데 총수익률을 계산하면 에러를 발생한다.")
    @Test
    void invalidCalculateTest() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new LottoMoney(0).calculate(1));
    }

    @DisplayName("구입 금액에서 구매한 로또 정보를 입력하면 나머지 금액을 반환한다.")
    @Test
    void expectedNumberOfIssuedTest() {
        List<Lotto> lottoList = Collections.singletonList(new Lotto(createLottoNumberList(new int[]{1, 2, 3, 4, 5, 6})));
        assertThat(new LottoMoney(3500).excludingAmount(lottoList)).isEqualTo(new LottoMoney(2500));
    }
}
