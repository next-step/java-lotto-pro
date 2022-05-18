package study.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 테스트")
class LottoTest {
    private static final List<Integer> VALID_LOTTO_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = Lotto.from(VALID_LOTTO_NUMBERS);
    }

    @Test
    @DisplayName("로또를 생성할 수 있다.")
    void 유효한_로또() {
        assertThat(new Lotto(lotto)).isNotNull();
    }

    @Test
    @DisplayName("입력받은 번호와 현재 번호를 비교하여 매치 카운트 수를 반환한다.")
    void 로또번호_비교() {
        Lotto anotherLotto = Lotto.from(Arrays.asList(1, 4, 5, 8, 9, 10));
        assertThat(lotto.matchCount(anotherLotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력받은 로또번호가 로또에 있는지 확인한다.")
    void 로또번호_존재_여부() {
        assertAll(
                () -> assertThat(lotto.has(new LottoNumber(6))).isTrue(),
                () -> assertThat(lotto.has(new LottoNumber(45))).isFalse()
        );
    }
}
