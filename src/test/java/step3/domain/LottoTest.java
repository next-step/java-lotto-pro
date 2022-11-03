package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    private List<LottoNumber> normalLottoNumbers;
    private List<LottoNumber> abnormalLottoNumbers;

    @BeforeEach
    void setUp() {
        normalLottoNumbers = new ArrayList<>();
        normalLottoNumbers.add(new LottoNumber(1));
        normalLottoNumbers.add(new LottoNumber(2));
        normalLottoNumbers.add(new LottoNumber(3));
        normalLottoNumbers.add(new LottoNumber(4));
        normalLottoNumbers.add(new LottoNumber(5));
        normalLottoNumbers.add(new LottoNumber(6));

        abnormalLottoNumbers = new ArrayList<>();
        abnormalLottoNumbers.add(new LottoNumber(1));
        abnormalLottoNumbers.add(new LottoNumber(2));
        abnormalLottoNumbers.add(new LottoNumber(3));
        abnormalLottoNumbers.add(new LottoNumber(4));
        abnormalLottoNumbers.add(new LottoNumber(5));
    }

    @DisplayName("로또는 로또번호 6개로 구성된다")
    @Test
    void 로또생성() {
        Lotto lotto = new Lotto(normalLottoNumbers);
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또는 로또번호 6개가 아닌경우는 예외")
    @Test
    void 로또생성시_6개가_아닌경우_예외() {
        assertThatThrownBy(() -> new Lotto(abnormalLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호에 대한 중복체크")
    @Test
    void 로또생성시_중복체크_예외() {
        abnormalLottoNumbers.add(new LottoNumber(5));

        assertThatThrownBy(() -> new Lotto(abnormalLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 동일성 테스트")
    @Test
    void 로또_equal_검증() {
        Lotto lotto1 = new Lotto(normalLottoNumbers);
        Lotto lotto2 = new Lotto(normalLottoNumbers);

        assertThat(lotto1.equals(lotto2)).isTrue();
    }

}
