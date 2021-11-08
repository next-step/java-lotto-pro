package lotto.module;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ManualGeneratorTest {

    @Test
    @DisplayName("입력받은 번호로 수동 로또번호 생성")
    public void manualLottoNumberGenerateTest() {
        assertThat(new ManualGenerator(Arrays.asList("1,2,3,4,5,6")).createLottos())
                .isEqualTo(Arrays.asList(LottoNumbers.fromString("1,2,3,4,5,6")));
    }
}
