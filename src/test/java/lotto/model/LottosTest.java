package lotto.model;

import lotto.enums.Rank;
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
        LottoNumbers lottoNumbers1 = createLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers2 = createLottoNumbers(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoNumbers lottoNumbers3 = createLottoNumbers(Arrays.asList(13, 14, 15, 16, 17, 18));
        List<LottoNumbers> lottoNumbers = Arrays.asList(lottoNumbers1, lottoNumbers2, lottoNumbers3);

        assertThat(Lottos.from(lottoNumbers))
                .isExactlyInstanceOf(Lottos.class)
                .hasFieldOrProperty("lottos")
                .extracting("lottos")
                .isInstanceOf(List.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"LOSE:1", "SIXTH:1", "FIFTH:1", "FOURTH:1", "THIRD:1", "SECOND:2", "FIRST:1"}, delimiter = ':')
    @DisplayName("당첨번호와 비교하여 등수별로 카운트 한다.")
    void rankCount_등수별_카운트(Rank rank, int expected) {
        List<LottoNumbers> lottoNumbersList = Arrays.asList(
                createLottoNumbers(Arrays.asList(2, 4, 20, 27, 43, 45)),  // LOSE
                createLottoNumbers(Arrays.asList(1, 3, 6, 27, 40, 45)),   // SIXTH
                createLottoNumbers(Arrays.asList(1, 2, 5, 27, 40, 45)),   // FIFTH
                createLottoNumbers(Arrays.asList(1, 5, 25, 30, 40, 41)),  // FOURTH
                createLottoNumbers(Arrays.asList(3, 5, 18, 37, 42, 45)),  // THIRD
                createLottoNumbers(Arrays.asList(1, 5, 18, 25, 37, 43)),  // SECOND
                createLottoNumbers(Arrays.asList(1, 5, 18, 25, 37, 44)),  // SECOND
                createLottoNumbers(Arrays.asList(1, 5, 18, 25, 37, 42))   // FIRST
        );
        Lottos lottos = Lottos.from(lottoNumbersList);

        LottoNumbers winningNumbers = createLottoNumbers(Arrays.asList(1, 5, 18, 25, 37, 42));

        RankCount rankCount = lottos.rankCount(winningNumbers);
        assertThat(rankCount)
                .isExactlyInstanceOf(RankCount.class);
        assertThat(rankCount.getCount(rank))
                .isEqualTo(expected);
    }
}
