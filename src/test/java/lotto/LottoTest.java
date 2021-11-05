package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.STREAM;

public class LottoTest {

    @DisplayName("로또 발행 테스트")
    @Test
    public void lottoIssueTest() {
        Lottos lottos = LottoMachine.issue(1000);
        assertThat(lottos).isNotNull();
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
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
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
        Lottos lottos = LottoMachine.issue(14_000);
        assertThat(lottos.count()).isEqualTo(14);
    }

    @DisplayName("주어진 로또 리스트에서 당첨된 로또 개수 구하기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:1", "4:4", "5:2", "6:1"}, delimiter = ':')
    public void winLotto_StatisticResultTest(int correspond, int win) {
        LottoWinReader reader = new LottoWinReader(Arrays.asList(1, 3, 5, 6, 11, 44));

        Lotto one = new Lotto(Arrays.asList(1, 3, 5, 6, 11, 44));

        Lotto two = new Lotto(Arrays.asList(1, 3, 5, 6, 11, 43));
        Lotto three = new Lotto(Arrays.asList(1, 3, 5, 6, 11, 42));

        Lotto four = new Lotto(Arrays.asList(1, 3, 5, 6, 17, 42));
        Lotto five = new Lotto(Arrays.asList(1, 3, 5, 6, 19, 42));
        Lotto six = new Lotto(Arrays.asList(1, 3, 5, 7, 11, 42));
        Lotto seven = new Lotto(Arrays.asList(1, 3, 4, 6, 19, 44));

        Lotto eight = new Lotto(Arrays.asList(10, 13, 5, 9, 11, 44));

        Lottos lottos = new Lottos(Arrays.asList(one, two, three, four, five, six, seven, eight));
        LottoStatisticResult result = reader.win(lottos);

        assertThat(result.get(correspond)).isEqualTo(win);
    }

    @DisplayName("구입한 금액 대비 당첨 수익률 구하기 테스트")
    @Test
    public void getRevenueTest() {
        Map<Integer, Integer> statistic = new HashMap<>();
        statistic.put(1, 10);
        statistic.put(2, 3);
        statistic.put(3, 1);
        statistic.put(4, 0);
        statistic.put(5, 0);
        statistic.put(6, 0);
        Revenue revenue = new Revenue(14_000, statistic);
        assertThat(revenue.percentage()).isEqualTo(0.35);
    }

}
