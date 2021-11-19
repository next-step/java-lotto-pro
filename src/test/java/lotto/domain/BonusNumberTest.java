package lotto.domain;

import lotto.consts.LottoNumberConst;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("보너스 번호에 대한 테스트")
public class BonusNumberTest {

    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @ValueSource(ints = { LottoNumberConst.START_NUMBER - 1, LottoNumberConst.END_NUMBER + 1, 4 })
    void 보너스_번호_유효성_검사_테스트(int bonusNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> new BonusNumber(bonusNumber, winningLotto));
    }
}
