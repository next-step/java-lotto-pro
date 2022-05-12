package study.lotto.automatic.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 테스트")
public class LottoTest {

    private static final List<Integer> VALID_LOTTO_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("로또를 생성할 수 있다.")
    void 유효한_로또() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(new Lotto(lottoNumbers)).isNotNull();
    }
}
