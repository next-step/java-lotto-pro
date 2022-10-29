package lotto;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoMatchNumberMap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchNumberMapTest {

    int[] winningNumbers = new int[] {1,2,3,4,5,6};

    @Test
    void 로또_넘버_매치_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new int[]{1,2,3,14,15,16}));
        lottoList.add(new Lotto(new int[]{1,2,3,24,25,26}));
        lottoList.add(new Lotto(new int[]{1,2,3,34,35,36}));
        Lotteries lotteries = new Lotteries(lottoList);
        LottoMatchNumberMap lottoMatchNumberMap = new LottoMatchNumberMap(lotteries, winningNumbers);
        assertThat(lottoMatchNumberMap.getMatchLottoNumber(3)).isEqualTo(3);
    }

    @Test
    void 로또_넘버_적은숫자_중복매치_불가능_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new int[]{1,2,3,14,15,16}));
        lottoList.add(new Lotto(new int[]{1,2,3,24,25,26}));
        lottoList.add(new Lotto(new int[]{1,2,3,34,35,36}));
        Lotteries lotteries = new Lotteries(lottoList);
        LottoMatchNumberMap lottoMatchNumberMap = new LottoMatchNumberMap(lotteries, winningNumbers);
        assertThat(lottoMatchNumberMap.getMatchLottoNumber(2)).isEqualTo(0);
    }

    @Test
    void 로또_넘버_전부맞을경우_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new int[]{1,2,3,4,5,6}));
        lottoList.add(new Lotto(new int[]{1,2,3,24,25,26}));
        lottoList.add(new Lotto(new int[]{1,2,3,34,35,36}));
        Lotteries lotteries = new Lotteries(lottoList);
        LottoMatchNumberMap lottoMatchNumberMap = new LottoMatchNumberMap(lotteries, winningNumbers);
        assertThat(lottoMatchNumberMap.getMatchLottoNumber(6)).isEqualTo(1);
    }
}
