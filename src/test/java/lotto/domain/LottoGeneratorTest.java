package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoGenerator.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoGeneratorTest {

    @Test
    @DisplayName("1 ~ 45 숫자 6개로 구성된 숫자세트를 생성할 수 있다.")
    public void constructor() {
        List<Integer> lottoNumbers = LottoGenerator.create();
        assertThat(lottoNumbers).hasSize(LOTTO_NUMBER_COUNT);
        assertAll(
                () -> assertThat(lottoNumbers.get(0)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(1)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(2)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(3)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(4)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(5)).isBetween(1, 45)
        );
    }
}
