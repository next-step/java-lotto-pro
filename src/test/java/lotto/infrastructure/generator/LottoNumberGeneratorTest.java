package lotto.infrastructure.generator;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    private NumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @Test
    public void generate_size() {
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    public void generate_duplicate() {
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        Set<Integer> nonDulicatedLottoNumbers = new HashSet<>(lottoNumbers);

        assertThat(lottoNumbers.size()).isEqualTo(nonDulicatedLottoNumbers.size());
    }

    @Test
    public void generate_sort() {
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoNumbers);

        for (int i = 0; i < lottoNumbers.size(); i++) {
            assertThat(lottoNumbers.get(i)).isEqualTo(sortedLottoNumbers.get(i));
        }
    }
}