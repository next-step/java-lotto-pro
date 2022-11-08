package study.step3.domain.lottonumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMatchResultTest {

    @Test
    @DisplayName("주어진 당첨 결과의 동일 여부를 반환한다")
    void equals_lotto_match_count_test() {
        LottoMatchResult lottoMatchResult = new LottoMatchResult(5L, false);
        boolean equalsLottoMatchCount = lottoMatchResult.isEqualsLottoMatchCount(new LottoMatchResult(5L, false));
        assertThat(equalsLottoMatchCount).isTrue();
    }

    @Test
    @DisplayName("당첨 결과에 보너스볼의 당첨 여부를 반환한다")
    void match_bonus_lotto_number_test() {
        LottoMatchResult lottoMatchResult = new LottoMatchResult(5L, true);
        assertThat(lottoMatchResult.isMatchedBonusLottoNumber()).isTrue();
    }

    @Test
    @DisplayName("주어진 당첨 개수 이상일 경우 [true]를 반환한다")
    void is_greater_than_lotto_match_result_test() {
        LottoMatchResult lottoMatchResult = new LottoMatchResult(4L, true);
        boolean isGreaterThanOrEqualMatchCount = lottoMatchResult.isGreaterThanOrEqualMatchCount(new LottoMatchResult(3L, true));
        assertThat(isGreaterThanOrEqualMatchCount).isTrue();
    }

    @Test
    @DisplayName("다수의 당첨 결과를 오름차순으로 정렬한다")
    void sort_lotto_match_result_test() {
        List<LottoMatchResult> lottoMatchResults = Arrays.asList(
                new LottoMatchResult(5L, false),
                new LottoMatchResult(6L, false),
                new LottoMatchResult(4L, false)
        );
        Collections.sort(lottoMatchResults);

        assertThat(lottoMatchResults).isSorted();
    }
}
