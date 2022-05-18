package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    @DisplayName("최대 값 만큼 로또 번호 개수가 존재하는지 확인")
    public void validNumberCount() {
        assertThat(LottoNumbers.PREPARED_NUMBERS.size()).isEqualTo(45);
    }

}
