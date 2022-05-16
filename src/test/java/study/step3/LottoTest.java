package study.step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.enumtype.LottoWinningType;

class LottoTest {
    @Test
    @DisplayName("로또 생성 테스트 - 수동생성")
    void createLotto_manualNumber() {
        Lotto lotto = new Lotto("1,2,22,30,35,45");
        Lotto winningLotto = new Lotto("1,2,22,30,35,45");
        assertThat(lotto.matchCount(winningLotto)).isSameAs(LottoWinningType.MATCH_COUNT_6.getMatchCount());
    }

    @Test
    @DisplayName("로또 생성 테스트 - 수동생성 - 중복 숫자")
    void createLotto_manualNumber_duplicateNumber() {
        assertThatThrownBy(() -> new Lotto("1,1,1,1,1,1"))
                .isInstanceOf(IllegalArgumentException.class);
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
