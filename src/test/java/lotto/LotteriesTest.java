package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.LottoTest.numbersToLotto;
import static org.assertj.core.api.Assertions.assertThat;

public class LotteriesTest {

    private static final WinningNumbers winningNumbers =
            new WinningNumbers(Arrays.asList(1,2,3,4,5,6), new BonusNumber(45));

    @Test
    @DisplayName("지난주 당첨 목록과 로또 여섯개 숫자가 일치하는 경우 테스트")
    void match6_test() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,4,5,6)));
        Lotteries lotteries = new Lotteries(lottoList);
        Map<Lotto, Rank> lottoNumberMatcher = lotteries.getLottoMatchRankMap(winningNumbers);
        int matchNumber = 0;
        //when (lotto가 하나이므로 키목록도 하나)
        for(Lotto lotto : lottoNumberMatcher.keySet()) {
            matchNumber = winningNumbers.getMatchNumber(lotto);
        }
        //then
        assertThat(matchNumber).isEqualTo(6);
    }

    @Test
    @DisplayName("지난주 당첨 목록과 로또 한개 숫자가 일치하는 경우 테스트")
    void match1_test() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(numbersToLotto(Arrays.asList(1,12,13,14,15,16)));
        Lotteries lotteries = new Lotteries(lottoList);
        Map<Lotto,Rank> lottoMatchNumberMap = lotteries.getLottoMatchRankMap(winningNumbers);
        int matchNumber = 0;
        //when (lotto가 하나이므로 키목록도 하나)
        for(Lotto lotto : lottoMatchNumberMap.keySet()) {
            matchNumber = winningNumbers.getMatchNumber(lotto);
        }
        //then
        assertThat(matchNumber).isEqualTo(1);
    }

    @Test
    @DisplayName("지난주 당첨 목록과 로또 숫자가 일치하는 것이 없는 경우 테스트")
    void no_match_test() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(numbersToLotto(Arrays.asList(11,12,13,14,15,16)));
        Lotteries lotteries = new Lotteries(lottoList);
        Map<Lotto,Rank> lottoMatchNumberMap = lotteries.getLottoMatchRankMap(winningNumbers);
        int matchNumber = 0;
        //when (lotto가 하나이므로 키목록도 하나)
        for(Lotto lotto : lottoMatchNumberMap.keySet()) {
            matchNumber = winningNumbers.getMatchNumber(lotto);
        }
        //then
        assertThat(matchNumber).isEqualTo(0);
    }
}
