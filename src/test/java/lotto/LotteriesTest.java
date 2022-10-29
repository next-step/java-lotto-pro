package lotto;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteriesTest {

    int[] winningNumbers = new int[] {1,2,3,4,5,6};

    @Test
    void 여섯개_매치_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new int[]{1,2,3,4,5,6}));
        Lotteries lotteries = new Lotteries(lottoList);
        Map<Lotto,Integer> lottoMatchNumberMap = lotteries.getLottoMatchNumberMap(winningNumbers);
        int matchNumber = 0;
        for(Lotto lotto : lottoMatchNumberMap.keySet()) {
            matchNumber = lotto.getMatchNumber(winningNumbers);
        }
        assertThat(matchNumber).isEqualTo(6);
    }

    @Test
    void 한개_매치_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new int[]{1,12,13,14,15,16}));
        Lotteries lotteries = new Lotteries(lottoList);
        Map<Lotto,Integer> lottoMatchNumberMap = lotteries.getLottoMatchNumberMap(winningNumbers);
        int matchNumber = 0;
        for(Lotto lotto : lottoMatchNumberMap.keySet()) {
            matchNumber = lotto.getMatchNumber(winningNumbers);
        }
        assertThat(matchNumber).isEqualTo(1);
    }

    @Test
    void 매치_없음_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new int[]{11,12,13,14,15,16}));
        Lotteries lotteries = new Lotteries(lottoList);
        Map<Lotto,Integer> lottoMatchNumberMap = lotteries.getLottoMatchNumberMap(winningNumbers);
        int matchNumber = 0;
        for(Lotto lotto : lottoMatchNumberMap.keySet()) {
            matchNumber = lotto.getMatchNumber(winningNumbers);
        }
        assertThat(matchNumber).isEqualTo(0);
    }
}
