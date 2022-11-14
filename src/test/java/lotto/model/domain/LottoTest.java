package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("로또 숫자 개수 불일치 시 예외처리")
    @Test
    void 로또_숫자_개수_불일치_예외처리() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Lotto.checkLottoNumberCount(5);
        });
        Lotto.checkLottoNumberCount(6);
    }

    @DisplayName("로또 중복 숫자 추가 예외처리")
    @Test
    void 로또_중복_숫자_예외처리() {
        Lotto lotto = new Lotto(Collections.singletonList(1));

        lotto.checkLottoNumberExist(LottoNumber.getLottoNumberByInt(2));
        lotto.addLottoNumber(LottoNumber.getLottoNumberByInt(2));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            lotto.checkLottoNumberExist(LottoNumber.getLottoNumberByInt(2));
        });
    }

    @DisplayName("로또 숫자 개수 초과 예외처리")
    @Test
    void 로또_숫자_개수_초과_예외처리() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            lotto.checkLottoNumberAddable();
        });
    }

    @DisplayName("로또 일치 확인")
    @Test
    void 로또_일치_확인() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,5,3,4,6));
        Lotto lotto3 = new Lotto(Arrays.asList(1,2,3,4,5,7));

        assertThat(lotto.equals(lotto2)).isTrue();
        assertThat(lotto.equals(lotto3)).isFalse();
    }

    @DisplayName("로또 비교_일치개수 확인")
    @Test
    void 로또_비교() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,7,8,9,10));
        int expected = 2;

        assertThat(lotto.compare(lotto2)).isEqualTo(expected);
    }
}
