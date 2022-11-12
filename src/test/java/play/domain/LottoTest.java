package play.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("로또 생성 시 숫자가 6개인지 테스트")
    void lotto_size_check() {
        Lotto lotto = Lotto.createAutoLotto();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);

    }

    @Test
    @DisplayName("로또 생성 시 1에서 45사이의 숫자인지 확인 테스트")
    void generate_lotto_default() {
        Lotto lotto = Lotto.createAutoLotto();
        List<Integer> lottoList = lotto.getNumbers();
        for (Integer num : lottoList) {
            assertThat(num).isBetween(1, 45);
        }
    }
}
