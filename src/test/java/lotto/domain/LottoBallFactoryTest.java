package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoBallFactoryTest {

    @DisplayName("중복없는 6개의 공을 생성한다")
    @Test
    void createSixBalls() {
        List<LottoBall> draw = LottoBallFactory.draw();
        assertAll(
                () -> assertThat(draw.size()).isEqualTo(6),
                () -> assertThat(draw).doesNotHaveDuplicates()
        );
    }

}
