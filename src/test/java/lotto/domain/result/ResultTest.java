package lotto.domain.result;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static lotto.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ResultTest {
    Result result;

    @BeforeAll
    void setUp() {
        result = Result.of(TICKET_LIST_SAMPLE, WINNING_LOTTO_NUMBERS_1_2_3_4_5_6);
    }

    @DisplayName("정적팩토리 메서드를 호출하면, 객체를 생성한다.")
    @Test
    void create() {
        assertThat(Result.of(TICKET_LIST_SAMPLE, WINNING_LOTTO_NUMBERS_1_2_3_4_5_6)).isInstanceOf(Result.class);
    }

    @DisplayName("구입금액을 입력으로 하는 earningsRate메서드를 호출하면, 투자수익율을 반환한다.")
    @Test
    void earningsRateTest() {
        assertThat(result.earningsRate(TOTAL_PAYMENT)).isEqualTo(RETURN_ON_INVESTMENT_SAMPLE);
    }

}
