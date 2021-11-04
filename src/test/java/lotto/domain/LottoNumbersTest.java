package lotto.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers =  LottoNumbers.create();
    }

    @DisplayName("6개의 로또 번호를 생성한다")
    @Test
    void testCreateLottoNumbers() {
        LottoNumbers lottoNumbers =  LottoNumbers.create();
        assertThat(lottoNumbers.getNumbers()).hasSize(6);
    }

    @DisplayName("1에서 45 사이의 숫자를 생성한다")
    @Test
    void testValidateNumber() {
        assertThat(lottoNumbers.getNumbers())
                .allMatch(number -> number.value() > 0 && number.value() < 46);
    }

    @DisplayName("숫자는 서로 겹치지 않는다")
    @Test
    void testNotDuplicate() {
        assertThat(lottoNumbers.getNumbers())
                .doesNotHaveDuplicates();
    }

    @DisplayName("숫자는 6/45 확률로 생성된다")
    @Test
    void testRandom() {
        // 100,000회 반복 생성하여 각 숫자를 카운팅 한다.
        // 각 숫자를 100,000로 나눈 값이 6/45와 근접해야 한다.
        Map<LottoNumber, Integer> countMap = new HashMap<>();
        int loopCount = 100000;
        for (int i = 0; i < loopCount; i++) {
            LottoNumbers lottoNumbers = LottoNumbers.create();
            List<LottoNumber> numbers = lottoNumbers.getNumbers();
            putNumberAndIncreaseCount(countMap, numbers);
        }
        double expected = 6d / 45d;
        for (LottoNumber number : countMap.keySet()) {
            Integer count = countMap.get(number);
            assertThat((double) count / loopCount).isEqualTo(expected, Offset.offset(0.005));
        }
    }

    private void putNumberAndIncreaseCount(Map<LottoNumber, Integer> countMap, List<LottoNumber> numbers) {
        for (LottoNumber number : numbers) {
            Integer count = countMap.getOrDefault(number, 0);
            countMap.put(number, count + 1);
        }
    }
}
