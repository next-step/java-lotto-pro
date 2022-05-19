package study.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private static final int LOTTO_NUMBER_SIZE = 6;

    @Test
    @DisplayName("로또 생성 테스트 - 수동생성 - 중복 숫자")
    void createLotto_manualNumber_duplicateNumber() {
        assertThatThrownBy(() -> new Lotto("1,1,1,1,1,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 생성 테스트 - 수동생성 - 범위 초과")
    void createLotto_manualNumber_rangeExceeded() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4, 46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 생성 테스트 - 수동생성 - 개수 초과")
    void createLotto_manualNumber_countExceeded() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호 포함 여부")
    void contains() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertThat(lotto.contains(new LottoNumber(1))).isTrue();
    }

    @Test
    @DisplayName("로또 번호 개수 반환")
    void size() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertThat(lotto.numberSize()).isSameAs(LOTTO_NUMBER_SIZE);
    }
}
