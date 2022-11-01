package lotto.domain.result;

import static lotto.domain.result.LottoResult.FIVE;
import static lotto.domain.result.LottoResult.FIVE_BONUS;
import static lotto.domain.result.LottoResult.FOUR;
import static lotto.domain.result.LottoResult.MISS;
import static lotto.domain.result.LottoResult.SIX;
import static lotto.domain.result.LottoResult.THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.stream.Stream;
import lotto.domain.matcher.count.MatchCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("로또를 맞춘 만큼 이익이 발생한다")
    void profit() {
        int profit = Stream.of(THREE, FOUR, FIVE, FIVE_BONUS, SIX).mapToInt(lottoResult -> {
            lottoResult.addTotalCount();
            return lottoResult.profit();
        }).sum();
        assertThat(profit).isEqualTo(5000 + 50000 + 1500000 + 30000000 + 2000000000);
    }

    @Test
    @DisplayName("matchCont 갯수가 같고 및 보너스볼 맟춤 여부에 따라 결과가 나온다")
    void matchResult() {
        assertAll(
                () -> assertSame(MISS.matchResult(new MatchCount(0, false)), MISS),
                () -> assertSame(THREE.matchResult(new MatchCount(3, false)), THREE),
                () -> assertSame(FOUR.matchResult(new MatchCount(4, false)), FOUR),
                () -> assertSame(FIVE.matchResult(new MatchCount(5, false)), FIVE),
                () -> assertSame(FIVE_BONUS.matchResult(new MatchCount(6, true)), FIVE_BONUS),
                () -> assertSame(SIX.matchResult(new MatchCount(6, false)), SIX)
        );
    }
}
