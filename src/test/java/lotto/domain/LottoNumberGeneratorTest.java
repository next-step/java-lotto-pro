package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @DisplayName("생성되는 로또 번호의 개수 확인")
    @Test
    void generateCount() {
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @DisplayName("생성되는 로또 번호의 중복 확인")
    @Test
    void generateDuplicate() {
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        Set<Integer> set = new HashSet<>(lottoNumbers);

        assertThat(lottoNumbers.size()).isEqualTo(set.size());
    }
}