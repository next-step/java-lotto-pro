package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("로또 숫자는 1 ~ 45의 숫자만 가진다.")
    void isNotNegativeLottoNumber(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));

    }

    @Test
    @DisplayName("보너스 넘버는 추출된 로또번호와 중복되지 않는다.")
    void isNotDistinctWinnerNumber() {
        Lotto winnerLotto = Lotto.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatIllegalArgumentException().isThrownBy(() ->
            LottoNumber.createBonusNumber(winnerLotto, 3)
        );
    }
}
