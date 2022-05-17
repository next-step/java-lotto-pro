package lotto.model;

import lotto.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("모든 로또 번호 리스트를 담고 있는 객체를 생성한다.")
    void Lottos_생성() {
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                LottoNumbers.createLottoNumbers(),
                LottoNumbers.createLottoNumbers(),
                LottoNumbers.createLottoNumbers());

        assertThat(Lottos.from(lottoNumbers))
                .isExactlyInstanceOf(Lottos.class)
                .hasFieldOrProperty("lottos")
                .extracting("lottos")
                .isInstanceOf(List.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"LOSE:2", "FOURTH:1", "THIRD:1", "SECOND:2", "FIRST:1"}, delimiter = ':')
    @DisplayName("당첨번호와 비교하여 등수별로 카운트 한다.")
    void rankCount_등수별_카운트(Rank rank, int expected) {
        List<LottoNumbers> lottoNumbersList = Arrays.asList(
                new LottoNumbers(Arrays.asList(2, 4, 20, 27, 43, 45)),  // LOSE
                new LottoNumbers(Arrays.asList(1, 3, 5, 27, 40, 45)),   // LOSE
                new LottoNumbers(Arrays.asList(1, 5, 25, 30, 40, 41)),  // FOURTH
                new LottoNumbers(Arrays.asList(3, 5, 18, 37, 42, 45)),  // THIRD
                new LottoNumbers(Arrays.asList(1, 5, 18, 25, 37, 43)),  // SECOND
                new LottoNumbers(Arrays.asList(1, 5, 18, 25, 37, 44)),  // SECOND
                new LottoNumbers(Arrays.asList(1, 5, 18, 25, 37, 42))   // FIRST
        );
        Lottos lottos = Lottos.from(lottoNumbersList);

        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 5, 18, 25, 37, 42));

        RankCount rankCount = lottos.rankCount(winningNumbers);
        assertThat(rankCount)
                .isExactlyInstanceOf(RankCount.class);
        assertThat(rankCount.getCount(rank))
                .isEqualTo(expected);
    }
}
