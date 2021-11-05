package lotto.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void 수익률을_계산한다() {
        List<Rank> ranks = Arrays.asList(Rank.FOURTH, Rank.NO_MATCH, Rank.NO_MATCH, Rank.NO_MATCH, Rank.NO_MATCH, Rank.NO_MATCH);
        Result result = new Result(ranks, new Money(14000));
        assertThat(result.getProfitRate()).isEqualTo(0.35, Offset.offset(0.01));
    }
}