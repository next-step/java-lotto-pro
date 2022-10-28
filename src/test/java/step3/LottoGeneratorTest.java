package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {"6,1,45", "3,1,5"})
    @DisplayName("랜덤 숫자를 생성할경우 각각 고유한 숫자를 리턴")
    void whenGenerateNumbers_thenUniqueNumbers(int needNumberCount, int from, int to) {
        List<Integer> numbers = LottoGenerator.createBetween(needNumberCount, from, to);
        
        assertThat(numbers).doesNotHaveDuplicates();
    }
}
