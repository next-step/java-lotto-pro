package domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RandomNumberGenerateStrategyTest {
    @Test
    void 랜덤_숫자_생성_테스트() {
        List<Integer> numberPool = Arrays.asList(1, 2, 3, 4, 5, 6);
        Set<Integer> numbers = RandomNumberGenerateStrategy.DEFAULT.generate(numberPool, 6);
        assertThat(numbers).hasSize(6);
        assertThat(numbers).containsAll(numberPool);
    }
}
