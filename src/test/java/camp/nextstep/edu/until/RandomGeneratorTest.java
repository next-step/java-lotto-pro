package camp.nextstep.edu.until;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RandomGeneratorTest {

    @Test
    void 유니크_숫자_리스트_생성시_from_to_사이의_range_수_만큼_중복되지_않은_랜덤한_숫자가_생성되어야_한다() {
        int from = 1;
        int to = 45;
        int range = 6;
        Set<Integer> numbers = RandomGenerator.createNonDuplicatedIntegerSet(from, to, range);

        assertThat(numbers.size()).isEqualTo(6);
        numbers.forEach(number -> assertThat(number).isBetween(from, to));
    }

    @Test
    void 유니크_숫자_리스트_생성시_from_to_보다_크거나_음수의_range_가_입력되면_예외가_발생해야_한다() {
        int from = 1;
        int to = 10;
        int overRange = 20;
        int minusRange = -1;

        assertThatThrownBy(() -> RandomGenerator.createNonDuplicatedIntegerSet(from, to, overRange))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> RandomGenerator.createNonDuplicatedIntegerSet(from, to, minusRange))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
