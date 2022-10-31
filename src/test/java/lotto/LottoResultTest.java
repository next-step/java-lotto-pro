package lotto;

import lotto.domain.*;
import lotto.view.LottoResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.LottoTest.numbersToLotto;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private static final WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
    private static final LottoResultView lottoResultView = new LottoResultView();

    @Test
    @DisplayName("지난주 당첨번호와 숫자가 3개 일치하는 로또가 3개 있는 경우 출력문구 테스트")
    void match3_lotto3_out_test() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,14,15,16)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,24,25,26)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,34,35,36)));
        Lotteries lotteries = new Lotteries(lottoList);
        //when
        LottoResult lottoResult = new LottoResult(lotteries, winningNumbers, new BuyAmount("3000"));
        //then
        assertThat(lottoResultView.lottoResultMessage(lottoResult.getLottoResultDto()))
                .contains("3개 일치 (5000원)- 3개");
    }

    @Test
    @DisplayName("지난주 당첨번호와 숫자가 3개 일치하는 로또가 1개, 4개 일치하는 로또가 1개, 5개 일치하는 로또가 1개인 경우 출력문구 테스트")
    void match3_lotto1_match4_lotto1_match5_lotto1_out_test() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,14,15,16)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,4,25,26)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,4,5,36)));
        Lotteries lotteries = new Lotteries(lottoList);
        //when
        LottoResult lottoResult = new LottoResult(lotteries, winningNumbers, new BuyAmount("3000"));
        //then
        assertThat(lottoResultView.lottoResultMessage(lottoResult.getLottoResultDto()))
                .contains("3개 일치 (5000원)- 1개\n4개 일치 (50000원)- 1개\n5개 일치 (1500000원)- 1개");
    }

    @Test
    @DisplayName("지난주 당첨번호와 숫자가 6개 일치하는 로또가 1개 있을 경우 출력문구 테스트")
    void match6_lotto1_out_test() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,4,5,6)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,4,25,26)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,4,5,36)));
        Lotteries lotteries = new Lotteries(lottoList);
        //when
        LottoResult lottoResult = new LottoResult(lotteries, winningNumbers, new BuyAmount("3000"));
        //then
        assertThat(lottoResultView.lottoResultMessage(lottoResult.getLottoResultDto()))
                .contains("6개 일치 (2000000000원)- 1개");
    }

    @Test
    @DisplayName("로또 수익률 1미만일 경우 (기준이 1이기 때문에 결과적으로 손해라는 의미임 출력문구 테스트")
    void profit_under1_test() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,14,15,16)));
        lottoList.add(numbersToLotto(Arrays.asList(1,12,13,14,25,26)));
        lottoList.add(numbersToLotto(Arrays.asList(1,12,13,14,15,36)));
        lottoList.add(numbersToLotto(Arrays.asList(1,12,13,14,25,36)));
        lottoList.add(numbersToLotto(Arrays.asList(1,12,13,14,45,36)));
        lottoList.add(numbersToLotto(Arrays.asList(1,12,13,14,27,36)));
        Lotteries lotteries = new Lotteries(lottoList);
        //when
        LottoResult lottoResult = new LottoResult(lotteries, winningNumbers, new BuyAmount("6000"));
        //then
        assertThat(lottoResultView.lottoResultMessage(lottoResult.getLottoResultDto()))
                .contains("기준이 1이기 때문에 결과적으로 손해라는 의미임");
    }
}
