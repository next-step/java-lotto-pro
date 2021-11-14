package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultTest {

    // TODO DELETE
    @DisplayName("로또 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"3,FIFTH", "4,FOURTH", "5,THIRD", "6,FIRST", "0,MISS", "2,MISS"})
    void findResult(int cnt, String resultName) {
        assertThat(LottoResult.findResult(cnt)).isEqualTo(LottoResult.valueOf(resultName));
    }

    @DisplayName("로또 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"3,false,FIFTH", "4,false,FOURTH", "5,false,THIRD", "5,true,SECOND", "6,false,FIRST",
        "0,false,MISS", "2,false,MISS", "4,true,FOURTH"})
    void findResult(int cnt, boolean containsBonus, String resultName) {
        assertThat(LottoResult.findResult(cnt, containsBonus)).isEqualTo(LottoResult.valueOf(resultName));
    }

}