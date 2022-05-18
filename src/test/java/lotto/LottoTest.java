package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;

@DisplayName("Lotto 클래스")
public class LottoTest {
    @DisplayName("로또 객체는 생성될 경우")
    @Nested
    class Lotto_Is_Created_Then {
        private Lotto lotto;

        @BeforeEach
        void setUp() {
            lotto = new Lotto();
        }

        @DisplayName("총 6개의 숫자를 갖는다.")
        @Test
        void hasSixNumbers() {
            assertThat(lotto.getNumbersCount()).isEqualTo(6);
        }

        @DisplayName("각 숫자는 1부터 45까지 숫자여야 한다.")
        @Test
        void hasOneToFourtyFiveRange() {
            for (int i = Lotto.LOTTO_FIRST_INDEX; i < Lotto.LOTTO_SIZE; i++) {
                final Integer number = lotto.getNumberByIndex(i);
                assertThat(number).isGreaterThanOrEqualTo(1);
                assertThat(number).isLessThanOrEqualTo(45);
            }
        }

        @DisplayName("각 숫자가 중복이 될 수 없다.")
        @Test
        void cannotBeDuplicated() {
            final Set<Integer> lottoSet = createNewSetUsingLotto(lotto);
            assertThat(lottoSet.size()).isEqualTo(lotto.getNumbersCount());
        }

        private Set<Integer> createNewSetUsingLotto(final Lotto lotto) {
            final Set<Integer> lottoSet = new HashSet<>();
            for(int i = 0; i < lotto.getNumbersCount(); i++){
                lottoSet.add(lotto.getNumberByIndex(i));
            }
            return lottoSet;
        }
    }
}
