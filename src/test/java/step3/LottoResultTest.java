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
    private LottoResult lottoResult;
    private int purchasedCount;

    @BeforeEach
    void initRules() {
        new WinnerRule().setWinnerRules();
        lottoResult = new LottoResult();
        purchasedCount = 0;
    }

    @DisplayName("최종_우승_금액_테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,1,3,4,0:60000", "0,3,3,3,1,1:15000"}, delimiter = ':')
    void 최종_우승_금액_테스트(String input, String expected) {
        makeResult(input);
        lottoResult.sumWinnerPrice();
        assertEquals(Integer.parseInt(expected), lottoResult.getTotalWinnerPrice());
    }

    @DisplayName("수익률_계산_테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,1,3,4,0:12.0", "0,3,3,3,1,1:2.5", "3,1,1,2,0,0:0.83"}, delimiter = ':')
    void 수익률_계산_테스트(String input, String expected) {
        makeResult(input);
        lottoResult.calculateProfitRate(purchasedCount);
        assertEquals(expected, Double.toString(lottoResult.getProfitRate()));
    }

    private void makeResult(String input) {
        String[] inputArr = input.split(COLON)[0].split(COMMA);
        for (String s : inputArr) {
            lottoResult.addResult(Integer.parseInt(s));
            purchasedCount++;
        }
    }
}
