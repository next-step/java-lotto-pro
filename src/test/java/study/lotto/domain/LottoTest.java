package study.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 테스트")
class LottoTest {
    private static final List<Integer> VALID_LOTTO_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);

    private LottoNumbers lottoNumbers = new LottoNumbers(VALID_LOTTO_NUMBERS);

    @Test
    @DisplayName("로또를 생성할 수 있다.")
    void 유효한_로또() {
        assertThat(new Lotto(lottoNumbers)).isNotNull();
    }

    @Test
    @DisplayName("입력받은 번호와 현재 번호를 비교하여 같은 숫자의 개수를 반환한다.")
    void 로또번호_비교() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 4, 7, 8, 9, 10)));
        assertThat(lotto.match(lottoNumbers)).isEqualTo(2);
    }
}
