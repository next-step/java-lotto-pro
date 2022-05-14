package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 머신 테스트")
class LottoMachineTest {
    private List<Integer> 로또_번호_목록;

    @BeforeEach
    void setUp() {
        로또_번호_목록 = LottoMachine.generate();
    }

    @Test
    @DisplayName("로또머신이 번호를 생성하면 6자리의 숫자가 생성되어야 한다")
    void lotto_number_create_test() {
        assertThat(로또_번호_목록.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("생성된 로또번호는 모두 1이상 45이하의 숫자이어야 한다")
    void lotto_number_create_test2() {
        for (int 로또_번호 : 로또_번호_목록) {
            assertThat(로또_번호).isGreaterThanOrEqualTo(1);
            assertThat(로또_번호).isLessThanOrEqualTo(45);
        }
    }

    @Test
    @DisplayName("생성된 로또번호는 서로 중복되지 않는 숫자이어야 한다")
    void lotto_number_create_test3() {
        Set<Integer> lottoSet = new HashSet<>(로또_번호_목록);
        assertThat(lottoSet.size()).isEqualTo(로또_번호_목록.size());
    }
}
