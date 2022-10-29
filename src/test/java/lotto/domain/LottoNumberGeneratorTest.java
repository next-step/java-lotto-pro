package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.generator.DefaultNumberGeneratorStrategy;
import lotto.domain.lotto.LottoNumber;
import lotto.generator.LottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberGeneratorTest {

    private final LottoNumberGenerator lottoNumberGenerator =
            LottoNumberGenerator.from(new DefaultNumberGeneratorStrategy());
    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUp() {
        this.lottoNumbers = lottoNumberGenerator.generate();
    }

    @Test
    @DisplayName("로또 번호는 6개이다.")
    void generateLottoNumbers1() {
        Assertions.assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호는 중복되지 않는다.")
    void generateLottoNumbers2() {
        Assertions.assertThat(lottoNumbers).hasSameSizeAs(new HashSet<>(lottoNumbers));
    }

    @Test
    @DisplayName("로또 번호는 1 ~ 45 사이의 값을 갖는다.")
    void generateLottoNumbers3() {
        lottoNumbers.sort(Comparable::compareTo);

        Assertions.assertThat(lottoNumbers.get(0))
                .isBetween(LottoNumber.from(1), LottoNumber.from(45));

        Assertions.assertThat(lottoNumbers.get(lottoNumbers.size() - 1))
                .isBetween(LottoNumber.from(1), LottoNumber.from(45));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("1 ~ 45 이외의 값이 입력되면 IllegalArgumentException 을 던진다.")
    void lottoNumberException(int input) {
        Assertions.assertThatThrownBy(() -> LottoNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
