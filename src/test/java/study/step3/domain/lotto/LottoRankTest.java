package study.step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.step3.domain.lottonumber.LottoMatchResult;
import study.step3.message.LottoMessage;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    @DisplayName("당첨 순위중 가장 낮은 순위를 반환한다")
    void get_minimum_winning_lotto_rank_test() {
        LottoRank lottoRank = LottoRank.minimumLottoRank();
        assertAll(
                () -> assertThat(lottoRank.isWinning()).isTrue(),
                () -> assertThat(lottoRank.isNone()).isFalse()
        );
    }

    @ParameterizedTest(name = "{index}등")
    @MethodSource("LottoRanks")
    @DisplayName("로또 번호 일치 개수가 주어지면 해당되는 당첨 순위를 반환한다")
    void match_winning_lotto_result_test(Long matchCount, boolean isMatchedBonusNumber, LottoRank actual) {
        LottoMatchResult lottoMatchResult = new LottoMatchResult(matchCount, isMatchedBonusNumber);
        LottoRank lottoRank = LottoRank.ofMatchResult(lottoMatchResult);
        assertThat(lottoRank).isEqualTo(actual);
    }

    @ParameterizedTest(name = "{index}등")
    @DisplayName("당첨 순위의 보너스볼 당첨 여부를 출력한다")
    @MethodSource("LottoRanks")
    void report_bonus_number_match_result_test(Long matchCount, boolean isMatchedBonusNumber, LottoRank rank) {
        String outputMessage = isMatchedBonusNumber
                ? LottoMessage.OUTPUT_LOTTO_RANK_IS_MATCHED_BONUS_NUMBER.message()
                : LottoMessage.OUTPUT_LOTTO_RANK_IS_NOT_MATCHED_BONUS_NUMBER.message();

        assertThat(rank.reportBonusNumberMatchResult())
                .isEqualTo(outputMessage);
    }

    @ParameterizedTest(name = "{index}등")
    @DisplayName("당첨 순위의 당첨 개수를 출력한다")
    @MethodSource("LottoRanks")
    void report_lotto_match_result_test(Long matchCount, boolean isMatchedBonusNumber, LottoRank rank) {
        assertThat(rank.reportLottoMatchResult()).isEqualTo(matchCount);
    }

    private static Stream<Arguments> LottoRanks() {
        return Stream.of(
                Arguments.of(6L, false, LottoRank.FIRST_PLACE),
                Arguments.of(5L, true, LottoRank.SECOND_PLACE),
                Arguments.of(5L, false, LottoRank.THIRD_PLACE),
                Arguments.of(4L, false, LottoRank.FOURTH_PLACE),
                Arguments.of(3L, false, LottoRank.FIFTH_PLACE)
        );
    }
}
