package study.step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    @DisplayName("전체 로또 번호 확인 - 중복 체크")
    void WholeLottoNumbers_checkDuplicateNumber() {
        Set<Integer> lottoNumberSet = new HashSet<>(Lotto.WHOLE_LOTTO_NUMBERS);
        assertThat(lottoNumberSet.size()).isEqualTo(Lotto.WHOLE_LOTTO_NUMBERS.size());
    }

    @Test
    @DisplayName("전체 로또 번호 확인 - 숫자 범위 체크")
    void WholeLottoNumbers_checkRange() {
        for (Integer integer : Lotto.WHOLE_LOTTO_NUMBERS) {
            assertThat(integer).isPositive();
            assertThat(integer).isLessThanOrEqualTo(45);
        }
    }

    @Test
    @DisplayName("로또 생성 테스트 - 자동생성")
    void createLotto_randomNumber() {
        Lotto lotto = new Lotto();
        assertThat(Lotto.WHOLE_LOTTO_NUMBERS.containsAll(lotto.getNumbers())).isTrue();
    }

    @Test
    @DisplayName("로또 생성 테스트 - 수동생성")
    void createLotto_manualNumber() {
        Lotto lotto = new Lotto("1,2,22,30,35,45");
        assertThat(Lotto.WHOLE_LOTTO_NUMBERS.containsAll(lotto.getNumbers())).isTrue();
    }

    @Test
    @DisplayName("로또 생성 테스트 - 수동생성 - 범위 초과")
    void createLotto_manualNumber_rangeExceeded() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4, 9999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 생성 테스트 - 수동생성 - 개수 초과")
    void createLotto_manualNumber_countExceeded() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호 일치 개수")
    void matchCount() {
        Lotto lotto = new Lotto("1,2,22,30,35,45");
        assertThat(lotto.matchCount(new Lotto("1,2,22,30,35,44"))).isEqualTo(5);
    }
}
