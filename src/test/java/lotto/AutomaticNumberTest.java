package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutomaticNumberTest {

    @Test
    @DisplayName("자등으로 중복되지 않는 로또 한 세트 뽑기")
    void pickAutomaticNumber() {
        LottoNumber automaticNumber = new AutomaticNumber();
        List<Integer> lottoNumbers = automaticNumber.getLottoNumbers();

        assertAll(
                () -> assertThat(lottoNumbers).hasSize(6),
                () -> assertThat(new HashSet<>(lottoNumbers)).hasSize(6)
        );
    }
}
