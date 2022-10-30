package lotto;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    int[] winningNumbers = new int[] {1,2,3,4,5,6};

    @Test
    void 로또_넘버_3개일치_3개_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new int[]{1,2,3,14,15,16}));
        lottoList.add(new Lotto(new int[]{1,2,3,24,25,26}));
        lottoList.add(new Lotto(new int[]{1,2,3,34,35,36}));
        Lotteries lotteries = new Lotteries(lottoList);
        LottoResult lottoResult = new LottoResult(lotteries, winningNumbers, 3000);
        assertThat(lottoResult.toString()).contains("3개 일치 (5000원)- 3개");
    }

    @Test
    void 로또_넘버_3개일치_1개_4개일치_1개_5개일치_1개_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new int[]{1,2,3,14,15,16}));
        lottoList.add(new Lotto(new int[]{1,2,3,4,25,26}));
        lottoList.add(new Lotto(new int[]{1,2,3,4,5,36}));
        Lotteries lotteries = new Lotteries(lottoList);
        LottoResult lottoResult = new LottoResult(lotteries, winningNumbers, 3000);
        assertThat(lottoResult.toString()).contains("3개 일치 (5000원)- 1개\n4개 일치 (50000원)- 1개\n5개 일치 (1500000원)- 1개");
    }

    @Test
    void 로또_넘버_6개일치_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new int[]{1,2,3,4,5,6}));
        lottoList.add(new Lotto(new int[]{1,2,3,4,25,26}));
        lottoList.add(new Lotto(new int[]{1,2,3,4,5,36}));
        Lotteries lotteries = new Lotteries(lottoList);
        LottoResult lottoResult = new LottoResult(lotteries, winningNumbers, 3000);
        assertThat(lottoResult.toString()).contains("6개 일치 (2000000000원)- 1개");
    }

    @Test
    void 로또_수익률_1미만_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new int[]{1,2,3,14,15,16}));
        lottoList.add(new Lotto(new int[]{1,12,13,14,25,26}));
        lottoList.add(new Lotto(new int[]{1,12,13,14,15,36}));
        lottoList.add(new Lotto(new int[]{1,12,13,14,25,36}));
        lottoList.add(new Lotto(new int[]{1,12,13,14,45,36}));
        lottoList.add(new Lotto(new int[]{1,12,13,14,27,36}));
        Lotteries lotteries = new Lotteries(lottoList);
        LottoResult lottoResult = new LottoResult(lotteries, winningNumbers, 6000);
        assertThat(lottoResult.toString()).contains("기준이 1이기 때문에 결과적으로 손해라는 의미임");
    }
}
