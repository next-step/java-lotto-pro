package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RandomNumberTest {

    @Test
    void 랜덤한_숫자를_생성한다() {
        RandomNumber number = new RandomNumber();
        int expected = number.generate();
        assertAll(
            () -> assertThat(expected).isGreaterThanOrEqualTo(1),
            () -> assertThat(expected).isLessThanOrEqualTo(45)
        );
    }
}
