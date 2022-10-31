package lotto;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberMatcher;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.LottoTest.numbersToLotto;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberMatcherTest {

    private static final WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

    @Test
    @DisplayName("지난주 당첨번호와 숫자 세개 일치하는 로또 개수가 3개인지 확인")
    void match3_lotto3_test() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,14,15,16)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,24,25,26)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,34,35,36)));
        Lotteries lotteries = new Lotteries(lottoList);
        //when
        LottoNumberMatcher lottoNumberMatcher = new LottoNumberMatcher(lotteries, winningNumbers);
        //then
        assertThat(lottoNumberMatcher.getMatchLottoNumber(3)).isEqualTo(3);
    }

    @Test
    @DisplayName("지난주 당첨번호와 3개 숫자가 일치하는 경우 2개 일치하는 경우에 카운팅 되는지 확인")
    void match_least_number_no_duplicate_test() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,14,15,16)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,24,25,26)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,34,35,36)));
        Lotteries lotteries = new Lotteries(lottoList);
        //when
        LottoNumberMatcher lottoNumberMatcher = new LottoNumberMatcher(lotteries, winningNumbers);
        //then
        assertThat(lottoNumberMatcher.getMatchLottoNumber(2)).isEqualTo(0);
    }

    @Test
    @DisplayName("지난주 당첨번호와 6개 숫자가 일치하는 경우 확인")
    void match6_lotto1_test() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,4,5,6)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,24,25,26)));
        lottoList.add(numbersToLotto(Arrays.asList(1,2,3,34,35,36)));
        Lotteries lotteries = new Lotteries(lottoList);
        //when
        LottoNumberMatcher lottoNumberMatcher = new LottoNumberMatcher(lotteries, winningNumbers);
        //then
        assertThat(lottoNumberMatcher.getMatchLottoNumber(6)).isEqualTo(1);
    }
}
