package study.step3.domain.lottostatistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRateOfReturnTest {

    @Test
    @DisplayName("수익율 생성 테스트")
    void create_lotto_rate_of_return_test() {
        LottoRateOfReturn lottoRateOfReturn = new LottoRateOfReturn(3.14);
        assertThat(lottoRateOfReturn.rate()).isEqualTo(3.14);
    }

    @Test
    @DisplayName("수익율이 0초과이면 수익임을 확인한다")
    void report_lotto_rate_of_return_revenue_test() {
        LottoRateOfReturn lottoRateOfReturn = new LottoRateOfReturn(3.14);
        assertThat(lottoRateOfReturn.result()).isEqualTo("수익");
    }

    @Test
    @DisplayName("수익율이 0미만이면 손해임을 확인한다")
    void report_lotto_rate_of_return_loss_test() {
        LottoRateOfReturn lottoRateOfReturn = new LottoRateOfReturn(-0.1);
        assertThat(lottoRateOfReturn.result()).isEqualTo("손해");
    }
}
