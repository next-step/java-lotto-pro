package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 생성기")
class LottoGeneratorTest {

    @DisplayName("로또 번호 생성")
    @Test
    void generate() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoNumbers = lottoGenerator.geneate();
        assertThat(lottoNumbers).hasSize(6);
    }
}
