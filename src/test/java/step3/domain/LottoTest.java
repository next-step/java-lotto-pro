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

    @DisplayName("로또 동일성 테스트")
    @Test
    void 로또_equal_검증() {
        List<LottoNumber> lottoNumbersCompare1= new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbersCompare1.add(new LottoNumber(i + 1));
        }

        List<LottoNumber> lottoNumbersCompare2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbersCompare2.add(new LottoNumber(i + 1));
        }

        Lotto lotto1 = new Lotto(lottoNumbersCompare1);
        Lotto lotto2 = new Lotto(lottoNumbersCompare2);

        assertThat(lotto1.equals(lotto2)).isTrue();
    }
}
