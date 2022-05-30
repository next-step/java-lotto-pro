package lotto.model;

import lotto.enums.Rank;
import lotto.generator.TestLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static lotto.model.LottoNumbers.createLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("모든 로또 번호 리스트를 담고 있는 객체를 생성한다.")
    void Lottos_생성() {
        LottoNumbers lottoNumbers1 = createLottoNumbers(new TestLottoNumbersGenerator("1,2,3,4,5,6"));
        LottoNumbers lottoNumbers2 = createLottoNumbers(new TestLottoNumbersGenerator("7,8,9,10,11,12"));
        LottoNumbers lottoNumbers3 = createLottoNumbers(new TestLottoNumbersGenerator("13,14,15,16,17,18"));
        List<LottoNumbers> lottoNumbers = Arrays.asList(lottoNumbers1, lottoNumbers2, lottoNumbers3);

        assertThat(Lottos.from(lottoNumbers))
                .isExactlyInstanceOf(Lottos.class)
                .hasFieldOrProperty("lottos")
                .extracting("lottos")
                .isInstanceOf(List.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"LOSE:1", "SIXTH:1", "FIFTH:1", "FOURTH:1", "THIRD:2", "SECOND:1", "FIRST:1"}, delimiter = ':')
    @DisplayName("당첨번호와 비교하여 등수별로 카운트 한다.")
    void rankCount_등수별_카운트(Rank rank, int expected) {
        List<LottoNumbers> lottoNumbersList = Arrays.asList(
                createLottoNumbers(new TestLottoNumbersGenerator("2, 4, 20, 27, 43, 45")),  // LOSE
                createLottoNumbers(new TestLottoNumbersGenerator("1, 4, 20, 27, 43, 45")),  // SEVENTH
                createLottoNumbers(new TestLottoNumbersGenerator("1, 5, 6, 27, 40, 45")),   // SIXTH
                createLottoNumbers(new TestLottoNumbersGenerator("1, 5, 18, 27, 40, 45")),  // FIFTH
                createLottoNumbers(new TestLottoNumbersGenerator("1, 5, 18, 25, 40, 41")),  // FOURTH
                createLottoNumbers(new TestLottoNumbersGenerator("1, 5, 18, 25, 37, 45")),  // THIRD
                createLottoNumbers(new TestLottoNumbersGenerator("1, 5, 18, 25, 37, 43")),  // THIRD
                createLottoNumbers(new TestLottoNumbersGenerator("1, 5, 18, 25, 37, 44")),  // SECOND
                createLottoNumbers(new TestLottoNumbersGenerator("1, 5, 18, 25, 37, 42"))   // FIRST
        );
        Lottos lottos = Lottos.from(lottoNumbersList);

        LottoNumbers winningNumbers = createLottoNumbers(new TestLottoNumbersGenerator("1, 5, 18, 25, 37, 42"));
        LottoNumber bonusNumber = LottoNumber.of(44);

        RankCount rankCount = lottos.rankCount(winningNumbers, bonusNumber);
        assertThat(rankCount)
                .isExactlyInstanceOf(RankCount.class);
        assertThat(rankCount.getCount(rank))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("수동 및 자동 로또번호 리스트를 하나로 합친다.")
    void union() {
        List<LottoNumbers> manualLottoNumbers = Arrays.asList(
                createLottoNumbers(new TestLottoNumbersGenerator("1, 2, 3, 4, 5, 6")),
                createLottoNumbers(new TestLottoNumbersGenerator("7, 8, 9, 10, 11, 12"))
        );
        List<LottoNumbers> autoLottoNumbers = Arrays.asList(
                createLottoNumbers(new TestLottoNumbersGenerator("2, 4, 20, 27, 43, 45")),
                createLottoNumbers(new TestLottoNumbersGenerator("1, 4, 20, 27, 43, 45"))
        );
        Lottos manualLottos = Lottos.from(manualLottoNumbers);
        Lottos autoLottos = Lottos.from(autoLottoNumbers);

        Lottos allLottos = manualLottos.union(autoLottos);

        assertThat(allLottos.lottosCount())
                .isEqualTo(4);
        assertThat(allLottos.toString())
                .contains("[1, 2, 3, 4, 5, 6]")
                .contains("[7, 8, 9, 10, 11, 12]")
                .contains("[2, 4, 20, 27, 43, 45]")
                .contains("[1, 4, 20, 27, 43, 45]");
    }
}
