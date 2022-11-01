package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.value.Rule;

class ResultTest {


    @ParameterizedTest
    @CsvSource(value = {"6,0:true", "5,1:true", "5,0:true", "4,0:true", "3,0:true","1,0:false","0,0:false"}, delimiter = ':')
    void 상금수여_여부_테스트(String match, boolean result) {
        int[] matchCountArray = Arrays.stream(match.split(Rule.DELIMITER)).mapToInt(Integer::parseInt).toArray();
        int matchCount = matchCountArray[0];
        int bonusCount = matchCountArray[1];
        assertThat(Result.getMatchResult(new Match(matchCount, bonusCount)).isRewarded()).isEqualTo(result);
    }
    @ParameterizedTest
    @CsvSource(value = {"6,0:FIRST_PRIZE", "5,1:SECOND_PRIZE_BONUS", "5,0:SECOND_PRIZE", "2,0:NO_PRIZE"}, delimiter = ':')
    void 수상_결과_테스트(String match, Result result) {
        int[] matchCount = Arrays.stream(match.split(Rule.DELIMITER)).mapToInt(Integer::parseInt).toArray();
        assertThat(Result.getMatchResult(new Match(matchCount[0], matchCount[1]))).isEqualTo(result);
    }

}