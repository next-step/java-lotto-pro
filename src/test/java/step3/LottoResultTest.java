package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.constant.WinnerRule;
import step3.model.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static step3.constant.Constant.Symbols.COLON;
import static step3.constant.Constant.Symbols.COMMA;

public class LottoResultTest {
    private LottoResult lottoResult = new LottoResult();

    @BeforeEach
    void initRules() { new WinnerRule().setWinnerRules(); }

    @DisplayName("최종_우승_금액_테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,1,3,4,0:60000", "0,3,3,3,1,1:15000"}, delimiter = ':')
    void 최종_우승_금액_테스트(String input, String expected) {
        String[] inputArr = input.split(COLON)[0].split(COMMA);
        for(String s : inputArr) {
            lottoResult.addResult(Integer.parseInt(s));
        }

        lottoResult.sumWinnerPrice();
        assertEquals(Integer.parseInt(expected), lottoResult.getTotalWinnerPrice());
    }
}
