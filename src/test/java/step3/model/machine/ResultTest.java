package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultTest {


    @ParameterizedTest
    @CsvSource(value = {"6:true", "5:true", "4:true", "3:true", "2:false","1:false","0:false"}, delimiter = ':')
    void 상금수여_여부_테스트(int match, boolean result) {
        assertThat(Result.getMatchResult(match).isRewarded()).isEqualTo(result);
    }
    @ParameterizedTest
    @CsvSource(value = {"6:FIRST_PRIZE", "5:SECOND_PRIZE", "4:THIRD_PRIZE", "3:FOURTH_PRIZE", "2:NO_PRIZE","1:NO_PRIZE","0:NO_PRIZE"}, delimiter = ':')
    void 수상_결과_테스트(int match, Result result) {
        assertThat(Result.getMatchResult(match)).isEqualTo(result);
    }

}