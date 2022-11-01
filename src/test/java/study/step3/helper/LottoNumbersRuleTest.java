package study.step3.helper;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersRuleTest {
    @Test
    void 섞여있는_숫자_리스트_반환_1부터_45까지() {
        List<Integer> shuffledNumbers = LottoNumbersRule.shuffledNumbers();
        List<Integer> sortedExpectedNumbers = generateNumbers();

        assertThat(shuffledNumbers).hasSize(45)
                .isNotEqualTo(sortedExpectedNumbers);

        shuffledNumbers.sort(null);
        assertThat(new HashSet(shuffledNumbers)).isEqualTo(new HashSet<>(sortedExpectedNumbers));
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
