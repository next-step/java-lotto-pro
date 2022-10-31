package step3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Lotto;
import step3.model.Lottos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    private void setUp() {
        this.lottoGenerator = new LottoGenerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,4,6,8})
    @DisplayName("generateByTimes 사용할때 지정된 갯수만큼 가지고있는 lottos 리턴")
    void generateByTimes(int count) {
        Lottos lottos = this.lottoGenerator.generateByTimes(count);

        assertThat(lottos.count()).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(strings = {"d,1,2,3,4,5", "1,2,3,4,5,g", "3,4,^,4,5,6"})
    @DisplayName("generate 사용할때 숫자가 아닌 문자가 포함되어있을경우 에러")
    void givenInvalidText_whenGenerate_thenThrow(String numberText) {
        assertThatThrownBy(() -> this.lottoGenerator.generate(numberText))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자를 기입해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,30,41,42,44,45", "23,25,26,30,36,40"})
    @DisplayName("generate 사용할때 숫자가 아닌 문자가 포함되어있지않을경우 lotto 리턴")
    void givenValidText_whenGenerate_thenLotto(String numberText) {
        Lotto lotto = this.lottoGenerator.generate(numberText);

        assertThat(lotto).isNotNull();
    }
}
