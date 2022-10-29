package domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RandomNumberGenerateStrategyTest {
    @Test
    void 랜덤_숫자_생성_테스트() {
        List<Integer> numbers = RandomNumberGenerateStrategy.DEFAULT.generate(
            Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        assertThat(numbers).hasSize(6);
    }
}
