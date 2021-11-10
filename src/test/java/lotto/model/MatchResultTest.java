package lotto.model;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.enums.Rank;

public class MatchResultTest {
    @Test
    @DisplayName("생성자의 매개변수로 null이 전달될 때 예외를 발생시킨다")
    void createByNull() {
        assertThatNullPointerException().isThrownBy(() ->
            new MatchResult(null, singletonList(Rank.FIRST))
        );
        assertThatNullPointerException().isThrownBy(() ->
            new MatchResult(new Payment(14000), (List<Rank>)null)
        );
    }

    @Test
    @DisplayName("로또 결과가 주어졌을 때 적절한 수익률을 반환하는지 테스트")
    void getRateOfReturn() {
        MatchResult matchResult = new MatchResult(new Payment(14000), Rank.FIFTH, Rank.SECOND);
        int expectedWinningMoney = Stream.of(Rank.FIFTH, Rank.SECOND)
            .mapToInt(Rank::getWinningMoney)
            .sum();
        RateOfReturn expectedRateOfReturn = new RateOfReturn((double)expectedWinningMoney / 14000);

        RateOfReturn actualRateOfReturn = matchResult.getRateOfReturn();

        assertThat(actualRateOfReturn).isEqualTo(expectedRateOfReturn);
    }

    @Test
    @DisplayName("로또 결과가 주어졌을 때 적절한 등수(Rank)의 갯수를 반환하는지 테스트")
    void countRank() {
        MatchResult matchResult = new MatchResult(new Payment(14000), Rank.FIFTH, Rank.FIFTH);

        int rankCount = matchResult.countRank(Rank.FIFTH);

        assertThat(rankCount).isEqualTo(2);
    }
}
