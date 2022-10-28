package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.util.LottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class LottosTest {

    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = Lottos.from(Arrays.asList(
            Lotto.from(lottoNumberGenerator.generate()),
            Lotto.from(lottoNumberGenerator.generate()),
            Lotto.from(lottoNumberGenerator.generate()),
            Lotto.from(lottoNumberGenerator.generate()),
            Lotto.from(lottoNumberGenerator.generate()),
            Lotto.from(lottoNumberGenerator.generate())
        ));
    }

    @DisplayName("생성된 로또가 Null 또는 공백인 경우 예외를 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNotNullOrEmpty(List<Lotto> input) {
        assertThatThrownBy(() -> Lottos.from(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성된 로또의 사이즈를 반환하는지 확인")
    @Test
    void size() {
        assertThat(lottos.size()).isEqualTo(6);
    }
}