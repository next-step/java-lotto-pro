package study.lotto.automatic.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    @DisplayName("로또번호를 비교하여 같은 번호의 리스트를 반환한다.")
    void 같은_번호_반환() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(Arrays.asList(3, 5, 1, 6, 9, 10));
        assertThat(lottoNumbers1.match(lottoNumbers2)).containsExactlyInAnyOrderElementsOf(Arrays.asList(1, 3, 5, 6));
    }

    @Nested
    @DisplayName("유효한 로또번호")
    class 유효한_로또번호 {
        private LottoNumbers validLottoNumbers;
        private List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        @BeforeEach
        void setUp() {
            validLottoNumbers = new LottoNumbers(numbers);
        }

        @Test
        @DisplayName("로또번호가 6개면 생성가능하다.")
        void 유효한_로또번호() {
            assertThat(validLottoNumbers).isNotNull();
        }

        @Test
        @DisplayName("로또번호를 Integer리스트 형태로 반환할 수 있다.")
        void 로또번호_정수_리스트_반환() {
            assertThat(validLottoNumbers.numbers()).containsExactlyElementsOf(numbers);
        }

        @Test
        @DisplayName("toString을 하면 로또번호를 (, )로 연결하여 스트링으로 반환한다.")
        void toString_로또번호_콤마로_연결하여_스트링_변환() {
            assertThat(validLottoNumbers).hasToString("1, 2, 3, 4, 5, 6");
        }
    }

    @Nested
    @DisplayName("무효한 로또번호")
    class 무효한_로또번호 {
        @Test
        @DisplayName("로또번호가 6개가 아니면 IllegalArgumentException 를 발생시킨다.")
        void 무효한_로또번호() {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
            assertThatThrownBy(() -> new LottoNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("로또번호가 중복된 경우 IllegalArgumentException 를 발생시킨다.")
        void 중복된_로또번호() {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
            assertThatThrownBy(() -> new LottoNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
        }
    }


}
