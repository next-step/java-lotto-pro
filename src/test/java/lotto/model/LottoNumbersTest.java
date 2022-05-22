package lotto.model;

import lotto.generator.TestLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constants.LottoConstant.LOTTO_PICK_COUNT;
import static lotto.model.LottoNumbers.createLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("당첨 번호와 일치하는 개수를 카운트 한다.")
    void matchCount_일치_카운트() {
        LottoNumbers lottoNumbers = createLottoNumbers(new TestLottoNumbersGenerator("10,4,1,33,23,45"));
        LottoNumbers winningNumbers = createLottoNumbers(new TestLottoNumbersGenerator("1,3,19,25,33,45"));

        assertThat(lottoNumbers.matchCount(winningNumbers))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("로또 번호 생성을 확인한다.")
    void createWinningNumbers_생성() {
        LottoNumbers winningNumbers = createLottoNumbers(new TestLottoNumbersGenerator("10, 4, 1, 23, 25, 45"));

        assertThat(winningNumbers.size())
                .isEqualTo(LOTTO_PICK_COUNT);
        assertThat(winningNumbers.toString())
                .isEqualTo("[10, 4, 1, 23, 25, 45]");
    }

}
