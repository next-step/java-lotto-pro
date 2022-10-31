package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class StatisticsTest {

    @Test
    void 수익률_테스트_0원() {
        assertThat(new Statistics(10000, 0).getStatisticResult()).isEqualTo(0);
        assertThat(new Statistics(0, 10000).getStatisticResult()).isEqualTo(0);
    }

    @Test
    void 수익률_테스트_음수_에러() {
        assertThatThrownBy(() -> new Statistics(-100, 0).getStatisticResult())
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Statistics(-100, -100).getStatisticResult())
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    void 수익률_테스트_정상() {
        assertThat(new Statistics(2000, 20000).getStatisticResult()).isEqualTo(10);
        assertThat(new Statistics(5000, 500).getStatisticResult()).isEqualTo(0.1);

    }
}