package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StatisticsTest {
    private List<Lotto> lottos;
    private Lotto win;
    private LottoNumber bonus;

    @BeforeEach
    void setup() {
        // given
        lottos = Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(23, 25, 33, 36, 39, 41)),
                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)),
                new Lotto(Arrays.asList(5, 9, 38, 41, 43, 44)),
                new Lotto(Arrays.asList(2, 8, 9, 18, 19, 21)),
                new Lotto(Arrays.asList(13, 14, 18, 21, 23, 35)),
                new Lotto(Arrays.asList(17, 21, 29, 37, 42, 45)),
                new Lotto(Arrays.asList(3, 8, 27, 30, 35, 44))
        );

        win = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonus = new LottoNumber(45);
    }

    @Test
    @DisplayName("로또 숫자리스트와 로또 당첨 번호를 비교하고 당첨된 숫자 갯수를 결과 맵에 count하여 담는다.")
    void 로또숫자비교_test() {
        // when
        Statistics statistics = new Statistics(win, bonus, lottos);

        // then
        assertThat(statistics.getResultMap().get(Rank.FIRST)).isEqualTo(0);
        assertThat(statistics.getResultMap().get(Rank.SECOND)).isEqualTo(0);
        assertThat(statistics.getResultMap().get(Rank.THIRD)).isEqualTo(0);
        assertThat(statistics.getResultMap().get(Rank.FOURTH)).isEqualTo(0);
        assertThat(statistics.getResultMap().get(Rank.FIFTH)).isEqualTo(1);
        assertThat(statistics.getResultMap().get(Rank.MISS)).isEqualTo(13);
    }

    @MethodSource(value = "lottoTestParameters")
    @ParameterizedTest(name = "로또 당첨 순위는 {1}이 {2}개 이다")
    void 로또숫자비교2_test(Lotto lotto, Rank rank, int result) {
        // given
        lottos = Arrays.asList(lotto);

        // when
        Statistics statistics = new Statistics(win, bonus, lottos);

        // then
        assertThat(statistics.getResultMap().get(rank)).isEqualTo(result);
    }

    @MethodSource(value = "lottoTestParameters")
    static Stream<Arguments> lottoTestParameters() {
        return Stream.of(
                arguments(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Rank.FIRST, 1),
                arguments(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)), Rank.SECOND, 1),
                arguments(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), Rank.THIRD, 1),
                arguments(new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)), Rank.FOURTH, 1),
                arguments(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)), Rank.FIFTH, 1)
        );
    }

    @Test
    @DisplayName("로또 총 구입 갯수는 14이다")
    void 로또_총갯수_test() {
        // when
        Statistics statistics = new Statistics(win, bonus, lottos);

        // then
        assertThat(statistics.getTotalCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 총 수익금액은 5000원이다.")
    void 로또_총수익_test() {
        // when
        Statistics statistics = new Statistics(win, bonus, lottos);
        assertThat(statistics.getTotalPrize()).isEqualTo(5000);
    }

    @Test
    @DisplayName("로또 총 수익 5000원, 총구매금액 14000원이고 수익률은 0.35이다.")
    void 수익률_test() {
        // when
        Statistics statistics = new Statistics(win, bonus, lottos);

        // then
        assertThat(statistics.getProfit()).isEqualTo(0.35);
    }

    @Test
    @DisplayName("보너스번호가 당첨번호에 존재하면 IllegalArgumentException을 발생시킨다.")
    void 보너스번호_예외_test() {
        //given
        bonus = new LottoNumber(1);

        // when - then
        assertThatThrownBy(() -> new Statistics(win, bonus, lottos))
                .isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("보너스번호가 지난당첨번호안에 중복이 될수 없습니다.");
    }
}
