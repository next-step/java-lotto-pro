package study.step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import study.step3.domain.lottostatistics.LottoStatistics;
import study.step3.domain.utils.LottoNumbersGenerator;
import study.step3.domain.utils.LottosGenerator;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class LottoMachineTest {

    @Test
    @DisplayName("구입 금액이 주어지면 구입 금액에 해당되는 로또를 발급한다 (개당 1,000원)")
    void issue_lottoGroup_if_given_money_test() {
        LottoMachine lottoMachine = new LottoMachine(14000, new RandomLottoIssuanceStrategy());
        Lottos lottos = lottoMachine.issue();
        assertThat(lottos.size()).isEqualTo(14);
    }

    @ParameterizedTest(name = "당첨 통계에 당첨 순위가 몇개있는지 검사한다 - 당첨 갯수: {2}, 당첨 순위: {3}")
    @MethodSource("createOneLottoWithLottoRankSource")
    @DisplayName("당첨 번호를 매칭하면 당첨 통계를 반환한다")
    // LottoMachine Test?? LottoStatistics Test??
    void count_lotto_rank_test(int[] lottoNumbers, int[] winningNumbers, long expectedLottoRankCount, LottoRank expectedLottoRank) {
        Lottos mockLottos = LottosGenerator.createLottos(Arrays.asList(lottoNumbers));
        RandomLottoIssuanceStrategy randomLottoIssuanceStrategy = Mockito.mock(RandomLottoIssuanceStrategy.class);
        when(randomLottoIssuanceStrategy.issue(14)).thenReturn(mockLottos);

        LottoMachine lottoMachine = new LottoMachine(14000, randomLottoIssuanceStrategy);
        Lottos lottos = lottoMachine.issue();

        LottoStatistics lottoStatistics = lottoMachine.match(lottos, LottoNumbersGenerator.createLottoNumbers(winningNumbers));
        long rankCount = lottoStatistics.findLottoLankCount(expectedLottoRank);

        assertThat(rankCount).isEqualTo(expectedLottoRankCount);
    }

    private static Stream<Arguments> createOneLottoWithLottoRankSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6}, 1L, LottoRank.FIRST_PLACE),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 11}, 1L, LottoRank.SECOND_PLACE),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 11, 12}, 1L, LottoRank.THIRD_PLACE),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 11, 12, 13}, 1L, LottoRank.FOURTH_PLACE),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 11, 12, 13, 14}, 0L, LottoRank.NONE)
        );
    }
}
