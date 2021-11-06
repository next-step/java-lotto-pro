package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBallFactoryTest {

    @DisplayName("6개의 공을 생성한다")
    @Test
    void createSixBalls() {
        List<LottoBall> draw = LottoBallFactory.draw();
        assertThat(draw.size()).isEqualTo(6);
    }

}