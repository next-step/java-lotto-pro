package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 숫자 리스트를 정상적으로 생성하는지 확인한다.")
    void createLottoNumbers_로또숫자_리스트() {
        assertThat(LottoNumbers.createLottoNumbers())
                .isExactlyInstanceOf(LottoNumbers.class)
                .hasFieldOrProperty("lottoNumbers")
                .extracting("lottoNumbers")
                .isInstanceOf(List.class);
    }

}