package lotto;

import lotto.model.LottoNumbers;
import lotto.model.LottoPrizeRanks;
import lotto.model.LottoStatics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoPrizeRank.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoStatics는 ")
public class LottoStaticsTest {
    @DisplayName("당첨 순위 별 갯수를 수집한다")
    @Test
    void collect() {
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new LottoNumbers(Arrays.asList(1, 2, 9, 10, 11, 12)));
        int bonus = 7;

        LottoStatics lottoStatics = new LottoStatics(lottoNumbers, winNumbers, bonus);

        LottoPrizeRanks lottoPrizeRanks = lottoStatics.collect();
        assertThat(lottoPrizeRanks).isEqualTo(new LottoPrizeRanks(Arrays.asList(FIFTH, MISS)));
    }

    @DisplayName("3등인 경우, 추가 번호를 가지고 있다면 2등으로 변경한다")
    @Test
    void collectWithBonus() {
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)));
        int bonus = 7;

        LottoStatics lottoStatics = new LottoStatics(lottoNumbers, winNumbers, bonus);

        LottoPrizeRanks lottoPrizeRanks = lottoStatics.collect();
        assertThat(lottoPrizeRanks).isEqualTo(new LottoPrizeRanks(Arrays.asList(SECOND)));
    }
}
