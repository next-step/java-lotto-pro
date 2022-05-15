package lotto.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomLottoNumbersGeneratorTest {
    @Test
    @DisplayName("RandomLottoNumbersGenerator로 6개 숫자 생성")
    void RandomLottoNumbersGenerator_generate(){
        List<Integer> randomLottoNumbers = RandomLottoNumbersGenerator.generate();
        assertThat(randomLottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("RandomLottoNumbersGenerator의 BaseNumber는 1~45로 구성")
    void RandomLottoNumbersGenerator_baseNumbers(){
        RandomLottoNumbersGenerator.generate();
        List<Integer> baseLottoNumbers = RandomLottoNumbersGenerator.getBaseLottoNumbers();
        for (int i = 1; i <= 45; i++) {
            assertThat(baseLottoNumbers.contains(i));
        }
        assertThat(baseLottoNumbers.size()).isEqualTo(45);
    }
}
