package Lotto;

import Lotto.enums.CompareEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareEnumTest {
    @ParameterizedTest
    @CsvSource(value = {"5:true:Second", "5:false:Third", "2:true:Fail"}, delimiter = ':')
    void 보너스_숫자를_포함하여_당첨_등수_계산(int hitCount, boolean match, CompareEnum rank) {
        assertThat(CompareEnum.valueOf(hitCount, match)).isEqualTo(rank);
    }
}
