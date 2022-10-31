package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또는 로또번호 6개로 구성된다")
    @Test
    void 로또생성() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(new LottoNumber(i + 1));
        }
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또는 로또번호 6개가 아닌경우는 예외")
    @Test
    void 로또생성_예외() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            lottoNumbers.add(new LottoNumber(i + 1));
        }

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
