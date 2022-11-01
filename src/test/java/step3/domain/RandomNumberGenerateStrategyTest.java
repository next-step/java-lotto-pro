package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class RandomNumberGenerateStrategyTest {
    @Test
    void 중복되지_않은_6개의_숫자로_이루어진_Set_을_생성할_수_있다() {
        assertThat(new RandomNumberGenerateStrategy().generate()).hasSize(6);
    }

    @Test
    void 생성된_숫자는_1부터_45_범위_내_숫자이다() {
        Set<Integer> generateRandomNumber = new RandomNumberGenerateStrategy().generate();
        Set<Integer> inRange = generateRandomNumber.stream()
                .filter(number -> number >= 1 && number <= 45)
                .collect(Collectors.toSet());
        assertThat(generateRandomNumber).isEqualTo(inRange);
    }
}
