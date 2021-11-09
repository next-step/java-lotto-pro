package lotto.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @DisplayName("자동 번호 생성")
    @Nested
    class AutoNumberCreateTest {

        private LottoNumbers lottoNumbers;
        private CollectionsShuffler shuffler;

        @BeforeEach
        void setUp() {
            shuffler = new CollectionsShuffler();
            lottoNumbers =  LottoNumbers.create(shuffler);
        }

        @DisplayName("6개의 로또 번호를 생성한다")
        @Test
        void testCreateLottoNumbers() {
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
                LottoNumbers lottoNumbers = LottoNumbers.create(shuffler);
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
    @DisplayName("수동 번호 생성")
    @Nested
    class ManualNumberCreateTest {

        @DisplayName("','로 나누었을 때 6개의 숫자로 나뉘는 문자열을 입력받는다")
        @Test
        void testInputWinningNumber() {
            LottoNumbers lottoNumbers = LottoNumbers.of("1,2,3,4,5,6");
            assertThat(lottoNumbers.getNumbers()).hasSize(6)
                    .contains(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
        }

        @DisplayName("6개가 아닌 값을 입력 받으면 오류를 발생한다")
        @ParameterizedTest
        @ValueSource(strings = {"1", "1,2", "", "1,2,3,4,5,6,7"})
        void testNumberLength(String text) {
            assertThatThrownBy(() -> LottoNumbers.of(text)).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("1에서 45 사이의 숫자를 생성한다")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,46"})
        void testValidateNumber(String text) {
            assertThatThrownBy(() -> LottoNumbers.of(text)).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자는 서로 겹치지 않아야 한다")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,5", "1, 3, 45, 6, 1, 4"})
        void testNotDuplicate(String text) {
            assertThatThrownBy(() -> LottoNumbers.of(text)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
