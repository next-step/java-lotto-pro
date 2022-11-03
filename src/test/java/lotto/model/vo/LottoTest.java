package lotto.model.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("로또 숫자 개수 불일치 시 예외처리")
    @Test
    void 로또_숫자_개수_불일치_예외처리() {
        Lotto lotto = new Lotto();
        lotto.addLottoNumber(new LottoNumber(1));
        lotto.addLottoNumber(new LottoNumber(2));
        lotto.addLottoNumber(new LottoNumber(3));
        lotto.addLottoNumber(new LottoNumber(4));
        lotto.addLottoNumber(new LottoNumber(5));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            lotto.checkLottoNumberCount();
        });
        lotto.addLottoNumber(new LottoNumber(6));
        lotto.checkLottoNumberCount();
    }

    @DisplayName("로또 중복 숫자 추가 예외처리")
    @Test
    void 로또_중복_숫자_예외처리() {
        Lotto lotto = new Lotto();
        lotto.addLottoNumber(new LottoNumber(1));

        lotto.checkLottoNumberExist(new LottoNumber(2));
        lotto.addLottoNumber(new LottoNumber(2));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            lotto.checkLottoNumberExist(new LottoNumber(2));
        });
    }

    @DisplayName("로또 숫자 개수 초과 예외처리")
    @Test
    void 로또_숫자_개수_초과_예외처리() {
        Lotto lotto = new Lotto();
        lotto.addLottoNumber(new LottoNumber(1));
        lotto.addLottoNumber(new LottoNumber(2));
        lotto.addLottoNumber(new LottoNumber(3));
        lotto.addLottoNumber(new LottoNumber(4));
        lotto.addLottoNumber(new LottoNumber(5));
        lotto.validateLottoNumberCount();
        lotto.addLottoNumber(new LottoNumber(6));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            lotto.validateLottoNumberCount();
        });
    }

    @DisplayName("로또 일치 확인")
    @Test
    void 로또_일치_확인() {
        Lotto lotto = new Lotto();
        lotto.addLottoNumber(new LottoNumber(1));
        lotto.addLottoNumber(new LottoNumber(2));
        lotto.addLottoNumber(new LottoNumber(3));
        lotto.addLottoNumber(new LottoNumber(4));
        lotto.addLottoNumber(new LottoNumber(5));
        lotto.addLottoNumber(new LottoNumber(6));

        Lotto lotto2 = new Lotto();
        lotto2.addLottoNumber(new LottoNumber(1));
        lotto2.addLottoNumber(new LottoNumber(2));
        lotto2.addLottoNumber(new LottoNumber(5));
        lotto2.addLottoNumber(new LottoNumber(3));
        lotto2.addLottoNumber(new LottoNumber(4));
        lotto2.addLottoNumber(new LottoNumber(6));

        Lotto lotto3 = new Lotto();
        lotto3.addLottoNumber(new LottoNumber(1));
        lotto3.addLottoNumber(new LottoNumber(2));
        lotto3.addLottoNumber(new LottoNumber(3));
        lotto3.addLottoNumber(new LottoNumber(4));
        lotto3.addLottoNumber(new LottoNumber(5));
        lotto3.addLottoNumber(new LottoNumber(7));

        assertThat(lotto.equals(lotto2)).isTrue();
        assertThat(lotto.equals(lotto3)).isFalse();
    }

    @DisplayName("로또 비교_일치개수 확인")
    @Test
    void 로또_비교() {
        Lotto lotto = new Lotto();
        lotto.addLottoNumber(new LottoNumber(1));
        lotto.addLottoNumber(new LottoNumber(2));
        lotto.addLottoNumber(new LottoNumber(3));
        lotto.addLottoNumber(new LottoNumber(4));
        lotto.addLottoNumber(new LottoNumber(5));
        lotto.addLottoNumber(new LottoNumber(6));

        Lotto lotto2 = new Lotto();
        lotto2.addLottoNumber(new LottoNumber(1));
        lotto2.addLottoNumber(new LottoNumber(2));
        lotto2.addLottoNumber(new LottoNumber(7));
        lotto2.addLottoNumber(new LottoNumber(8));
        lotto2.addLottoNumber(new LottoNumber(9));
        lotto2.addLottoNumber(new LottoNumber(10));

        int expected = 2;
        assertThat(lotto.compare(lotto2)).isEqualTo(expected);
    }
}
