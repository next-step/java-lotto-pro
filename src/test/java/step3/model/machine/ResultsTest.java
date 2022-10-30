package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.model.lotto.Lotto;
import step3.model.lotto.Ticket;

class ResultsTest {
    private Results results;

    @BeforeEach
    void setup() {
        results = new Results();
        results.recordResult(Result.SECOND_PRIZE);
        results.recordResult(Result.THIRD_PRIZE);
        results.recordResult(Result.THIRD_PRIZE);
        results.recordResult(Result.FOURTH_PRIZE);
    }

    @Test
    void 최종_상금() {
        assertThat(results.getWinningPrize()).isEqualTo(
                Result.SECOND_PRIZE.getTotalPrize(1)
                + Result.THIRD_PRIZE.getTotalPrize(2)
                + Result.FOURTH_PRIZE.getTotalPrize(1)
        );
    }
    @Test
    void 우승자_없으면_상금도_없다() {
        assertThat(Result.FIRST_PRIZE.getTotalPrize(0)).isEqualTo(0);
    }
    @Test
    void 맞추지_못한사람은_상금이_없다() {
        assertThat(Result.NO_PRIZE.getTotalPrize(100)).isEqualTo(0);
    }
}