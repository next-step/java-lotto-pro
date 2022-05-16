package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    @DisplayName("당첨 번호와 일치하는 개수를 카운트 한다.")
    void matchCount_일치_카운트() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(10, 4, 1, 33, 23, 45));
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 3, 19, 25, 33, 45));

        assertThat(lottoNumbers.matchCount(winningNumbers))
                .isEqualTo(3);
    }

}