package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    @Test
    @DisplayName("6개의 중복되지 않는 로또 번호 생성")
    void generate_중복_없는_번호_6개() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();
        Set<Integer> expected = new HashSet<>(lottoNumbers);

        assertThat(lottoNumbers).hasSize(6);
        assertThat(expected).containsAll(lottoNumbers);
    }
}
