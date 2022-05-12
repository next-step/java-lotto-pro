package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.LottoPrizeRank.THREE;
import static lotto.LottoPrizeRank.NONE;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoStatics는 ")
public class LottoStaticsTest {
    @DisplayName("5000원 1개를 가진다")
    @Test
    void collect_1(){
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new LottoNumbers(Arrays.asList(1, 2, 9, 10, 11, 12)));

        LottoStatics lottoStatics = new LottoStatics(lottoNumbers, winNumbers);

        List<LottoPrizeRank> lottoPrizeRanks = lottoStatics.collect();
        assertThat(lottoPrizeRanks).containsExactly(THREE, NONE);
    }

    @DisplayName("5000원 2개를 가진다")
    @Test
    void collect_2(){
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new LottoNumbers(Arrays.asList(1, 2, 3, 10, 11, 12)));

        LottoStatics lottoStatics = new LottoStatics(lottoNumbers, winNumbers);

        List<LottoPrizeRank> lottoPrizeRanks = lottoStatics.collect();
        assertThat(lottoPrizeRanks).containsExactly(THREE, THREE);
    }
}
