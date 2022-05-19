package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    private Lotto stringToLotto;

    @BeforeEach
    void setUp() {
        String input = "1, 2, 3, 4, 5, 6";
        Lotto lotto = LottoFactory.manualGenerator(input);
        stringToLotto = lotto;
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void 로또_생성_입력(int input) {
        long count = stringToLotto.getLottoNumbers().stream()
                .filter(lottoNumber -> lottoNumber.equals(new LottoNumber(input)))
                .count();
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 로또_생성_0보다_작은_수() {
        assertThatThrownBy(() -> LottoFactory.manualGenerator("-1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_생성_45보다_큰_수() {
        assertThatThrownBy(() -> LottoFactory.manualGenerator("46, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_생성_중복_수() {
        assertThatThrownBy(() -> LottoFactory.manualGenerator("1, 1, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
