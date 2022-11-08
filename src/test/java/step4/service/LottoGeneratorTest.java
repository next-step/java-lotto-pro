package step4.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.Lottos;

import static org.assertj.core.api.Assertions.assertThat;

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
}
