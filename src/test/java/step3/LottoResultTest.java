package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.constant.WinnerRule;
import step3.model.LottoResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static step3.constant.Constant.Symbols.*;

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
    @CsvSource(value = {"3-false,1-false,3-false,4-false,0-false:60000",
            "0-false,3-false,3-false,3-false,1-false,1-false:15000"}, delimiter = ':')
    void 최종_우승_금액_테스트(String input, String expected) {
        makeResult(input);
        lottoResult.sumWinnerPrice();
        assertEquals(Integer.parseInt(expected), lottoResult.getTotalWinnerPrice());
    }

    @DisplayName("수익률_계산_테스트")
    @ParameterizedTest
    @CsvSource(value = {"3-false,1-false,3-false,4-false,0-false:12.0",
            "0-false,3-false',3-false,3-false,1-false,1-false:2.5",
            "3-false,1-false,1-false,2-false,0-false,0-false:0.83"}, delimiter = ':')
    void 수익률_계산_테스트(String input, String expected) {
        makeResult(input);
        lottoResult.calculateProfitRate(purchasedCount);
        assertEquals(expected, Double.toString(lottoResult.getProfitRate()));
    }

    private void makeResult(String input) {
        String[] inputArr = input.split(COLON)[0].split(COMMA);
        for (String s : inputArr) {
            String[] detail = s.split(BAR);
            lottoResult.addResult(Integer.parseInt(detail[0]), detail[1].equals("true"));
            purchasedCount++;
        }
    }
}
