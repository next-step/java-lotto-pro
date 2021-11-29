package lotto.domain;

import lotto.consts.LottoNumberConst;
import lotto.exception.DuplicateLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("보너스 번호에 대한 테스트")
public class BonusNumberTest {

    private final WinningLotto winningLotto = new WinningLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

    @ParameterizedTest
    @ValueSource(ints = { LottoNumberConst.START_NUMBER - 1, LottoNumberConst.END_NUMBER + 1 })
    void 보너스_번호_범위_테스트(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new BonusNumber(number, winningLotto));
    }

    @Test
    void 보너스_번호_중복_테스트() {
        assertThatExceptionOfType(DuplicateLottoNumberException.class).isThrownBy(() -> new BonusNumber(4, winningLotto));
    }
}
