package lottoauto.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberExtractorTest {

    @Test
    void 중복되지않는_숫자_6개_추출() {
        RandomNumberExtractor randomNumberExtractor = new RandomNumberExtractor();
        List<Integer> numbers = randomNumberExtractor.getRandomNumbers();
        assertThat(numbers.size()).isEqualTo(6);
    }
}