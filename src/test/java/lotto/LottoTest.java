package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Winnings.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 발행 테스트")
    @Test
    public void lottoIssueTest() {
        PurchaseAmount amount = new PurchaseAmount(1_000);
        LottoMachine lottoMachine = new LottoMachine(digit -> Arrays.asList(1, 2, 6, 10, 17, 42));
        Lottos lottos = lottoMachine.issue(amount);
        assertThat(lottos).isNotEmpty();
        assertThat(lottos).containsExactly(new Lotto(Arrays.asList(1, 2, 6, 10, 17, 42)));
    }

    @DisplayName("로또 숫자를 비교하는 테스트")
    @Test
    public void lottoNumberEqualTest() {
        LottoNumber one = new LottoNumber(1);
        assertThat(one).isEqualTo(new LottoNumber(1));
    }

    @DisplayName("로또의 숫자 개수 초과 발행 예외 테스트")
    @Test
    public void lottoNumberCountTest() {
        assertThatThrownBy(() -> {
            LottoMachine lottoMachine = new LottoMachine(digit -> Arrays.asList(1, 2, 3, 4, 5, 6, 7));
            lottoMachine.issue(new PurchaseAmount(1_000));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("제한된 범위의 숫자 생성 시 예외 테스트")
    @Test
    public void lottoNumber_OutOfRange_ExceptionTest() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 숫자를 오름차순으로 정렬 테스트")
    @Test
    public void lottoNumberAscendingSortedTest() {
        Lotto lotto = new Lotto(Arrays.asList(6, 5, 2, 1, 15, 42));
        assertThat(lotto).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(5),
                new LottoNumber(6), new LottoNumber(15), new LottoNumber(42));
    }

    @DisplayName("로또의 숫자를 다음과 같은 형식으로 출력 테스트 [숫자, 숫자, 숫자, 숫자, 숫자, 숫자]")
    @Test
    public void printLottoNumbersTest() {
        Lotto lotto = new Lotto(Arrays.asList(6, 5, 2, 1, 15, 42));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 5, 6, 15, 42]");
    }

    @DisplayName("주어진 금액만큼 로또 개수를 발행 테스트")
    @Test
    public void lottoCount_InAmountTest() {
        PurchaseAmount amount = new PurchaseAmount(14_000);
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());
        Lottos lottos = lottoMachine.issue(amount);
        assertThat(lottos.count()).isEqualTo(14);
    }

    @DisplayName("주어진 로또 리스트에서 당첨된 로또 개수 구하기(3개일치할 때) 테스트 ")
    @Test
    public void winningsByFIFTHTest() {
        LottoWinReader reader = new LottoWinReader(Arrays.asList(1, 3, 5, 6, 11, 44), 39);
        Lotto lotto = new Lotto(Arrays.asList(39, 13, 5, 9, 11, 44));
        LottoStatistic statistic = reader.distinguish(new Lottos(Arrays.asList(lotto)));
        Map<Winnings, Integer> result = statistic.result(Arrays.asList(FIFTH));
        assertThat(result.get(FIFTH)).isEqualTo(1);
    }

    @DisplayName("주어진 로또 리스트에서 당첨된 로또 개수 구하기(4개일치할 때) 테스트 ")
    @Test
    public void winningsByFORTHTest() {
        LottoWinReader reader = new LottoWinReader(Arrays.asList(1, 3, 5, 6, 11, 44), 39);
        Lotto one = new Lotto(Arrays.asList(1, 3, 5, 6, 17, 42));
        Lotto two = new Lotto(Arrays.asList(1, 3, 5, 6, 19, 42));
        Lotto three = new Lotto(Arrays.asList(1, 3, 5, 7, 11, 42));
        Lotto four = new Lotto(Arrays.asList(1, 3, 4, 6, 19, 44));
        LottoStatistic statistic = reader.distinguish(new Lottos(Arrays.asList(one, two, three, four)));
        Map<Winnings, Integer> result = statistic.result(Arrays.asList(FORTH));
        assertThat(result.get(FORTH)).isEqualTo(4);
    }

    @DisplayName("주어진 로또 리스트에서 당첨된 로또 개수 구하기(5개일치할 때/보너스 번호 일치 X) 테스트 ")
    @Test
    public void winningsByTHRIDTest() {
        LottoWinReader reader = new LottoWinReader(Arrays.asList(1, 3, 5, 6, 11, 44), 39);
        Lotto one = new Lotto(Arrays.asList(1, 3, 5, 6, 11, 43));
        Lotto two = new Lotto(Arrays.asList(1, 3, 5, 6, 11, 42));
        Lottos lottos = new Lottos(Arrays.asList(one, two));
        LottoStatistic statistic = reader.distinguish(lottos);
        Map<Winnings, Integer> result = statistic.result(Arrays.asList(THIRD, SECOND));
        assertThat(result.get(THIRD)).isEqualTo(2);
        assertThat(result.get(SECOND)).isEqualTo(0);
    }

    @DisplayName("주어진 로또 리스트에서 당첨된 로또 개수 구하기(5개일치할 때/보너스 번호 일치 O) 테스트 ")
    @Test
    public void winningsBySECONDTest() {
        LottoWinReader lottoWinReader = new LottoWinReader(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10))));
        LottoStatistic statistic = lottoWinReader.distinguish(lottos);
        Map<Winnings, Integer> result = statistic.result(Arrays.asList(THIRD, SECOND));
        assertThat(result.get(SECOND)).isEqualTo(1);
        assertThat(result.get(THIRD)).isEqualTo(0);
    }

    @DisplayName("주어진 로또 리스트에서 당첨된 로또 개수 구하기(6개일치할 때) 테스트 ")
    @Test
    public void winningsByFIRSTTest() {
        LottoWinReader lottoWinReader = new LottoWinReader(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
        LottoStatistic statistic = lottoWinReader.distinguish(lottos);
        Map<Winnings, Integer> result = statistic.result(Arrays.asList(FIRST));
        assertThat(result.get(FIRST)).isEqualTo(1);
    }

    @DisplayName("구입한 금액 대비 당첨 수익률 구하기 테스트")
    @Test
    public void getRevenueTest() {
        Map<Winnings, Integer> statistic = new HashMap<>();
        statistic.put(MISS, 13);
        statistic.put(FIFTH, 1);
        statistic.put(FORTH, 0);
        statistic.put(THIRD, 0);
        statistic.put(SECOND, 0);
        statistic.put(FIRST, 0);
        PurchaseAmount amount = new PurchaseAmount(14_000);
        Revenue revenue = new Revenue(amount, statistic);
        assertThat(revenue.percentage()).isEqualTo(0.35);
    }

}
