package lotto;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.game.LottoGame;
import lotto.game.LottoGameResult;
import lotto.rank.LottoRank;
import static lotto.rank.LottoRank.*;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoGameResultTest {

    @ParameterizedTest
    @MethodSource("provideLottoGameResultWithTotalPrize")
    void 당첨총액_계산(List<LottoRank> rankList, Long expected){
        LottoGameResult lottoGameResult = new LottoGameResult(rankList);
        assertThat(lottoGameResult.totalPrize()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoGameResultWithTotalPrize(){
        LottoRank[] ranks = {NO_PRIZE,THIRD_PLACE,THIRD_PLACE};
        List<LottoRank> testRankList1 = Arrays.asList(ranks);
        long testPrize1 = THIRD_PLACE.getPrize() * 2;
        ranks = new LottoRank[]{NO_PRIZE, NO_PRIZE
                , THIRD_PLACE, THIRD_PLACE
                , FOURTH_PLACE, FOURTH_PLACE, FOURTH_PLACE
                , SECOND_PLACE
        };
        List<LottoRank> testRankList2 = Arrays.asList(ranks);
        long testPrize2 = THIRD_PLACE.getPrize() * 2 + FOURTH_PLACE.getPrize() * 3 + SECOND_PLACE.getPrize() * 1;
        return Stream.of(
                Arguments.of(testRankList1,testPrize1),
                Arguments.of(testRankList2,testPrize2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoGameResultWithYield")
    void 수익률_계산(List<LottoRank> rankList, Double yield){
        LottoGameResult lottoGameResult = new LottoGameResult(rankList);
        assertThat(lottoGameResult.yield()).isEqualTo(yield);
    }

    private static Stream<Arguments> provideLottoGameResultWithYield(){
        LottoRank[] ranks = {NO_PRIZE,THIRD_PLACE,THIRD_PLACE};
        List<LottoRank> testRankList1 = Arrays.asList(ranks);
        double testYield1 = (double) (THIRD_PLACE.getPrize() * 2) / (LottoGame.LOTTO_PRICE * 3);
        ranks = new LottoRank[]{NO_PRIZE, NO_PRIZE
                , THIRD_PLACE, THIRD_PLACE
                , FOURTH_PLACE, FOURTH_PLACE, FOURTH_PLACE
                , SECOND_PLACE
        };
        List<LottoRank> testRankList2 = Arrays.asList(ranks);
        double testYield2 = (double) (THIRD_PLACE.getPrize() * 2 + FOURTH_PLACE.getPrize() * 3 + SECOND_PLACE.getPrize() * 1) / (LottoGame.LOTTO_PRICE * 8);
        return Stream.of(
                Arguments.of(testRankList1,testYield1),
                Arguments.of(testRankList2,testYield2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoRankList")
    void 당첨통계_계산(List<LottoRank> rankList){
        LottoGameResult lottoGameResult = new LottoGameResult(rankList);
        Map<LottoRank,Integer> statistics = lottoGameResult.statistics();
        assertThat(statistics.get(NO_PRIZE) == null).isTrue();
        for( LottoRank rank : EnumSet.of(FOURTH_PLACE,THIRD_PLACE,SECOND_PLACE,FIRST_PLACE)) {
            long count =rankList.stream().filter(item -> item == rank).collect(counting());
            assertLottoRankCount(statistics, rank, count);
        }
    }
    private void assertLottoRankCount(Map<LottoRank,Integer> statistics, LottoRank rank, long count){
        assertThat(statistics.getOrDefault(rank,0)).isEqualTo(count);
    }

    private static Stream<List<LottoRank>> provideLottoRankList(){
        LottoRank[] ranks = {NO_PRIZE,THIRD_PLACE,THIRD_PLACE};
        List<LottoRank> testRankList1 = Arrays.asList(ranks);
        ranks = new LottoRank[]{NO_PRIZE,NO_PRIZE,NO_PRIZE,NO_PRIZE,THIRD_PLACE,THIRD_PLACE,FOURTH_PLACE,FOURTH_PLACE,SECOND_PLACE,FOURTH_PLACE};
        List<LottoRank> testRankList2 = Arrays.asList(ranks);
         return Stream.of(testRankList1,testRankList2);
    }
}
