package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("수익률 테스트")
class ProfitRateTest {

    @DisplayName("당첨금액 / 구매금액으로 수익률이 계산되어야 한다")
    @ParameterizedTest
    @CsvSource(value = {"5000,14000:0.35", "2000,6000:0.33", "30000,5000:6"}, delimiter = ':')
    void z(String input, double rate) {
        String[] inputs = input.split(",");
        int 당첨금액 = Integer.parseInt(inputs[0]);
        int 구매금액 = Integer.parseInt(inputs[1]);

        ProfitRate profitRate = new ProfitRate(당첨금액, 구매금액);
        assertThat(profitRate.getRate()).isEqualTo(rate);
    }
}
