package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.constant.WinnerRule;
import step3.model.Lotto;
import step3.model.LottoResult;
import step3.model.Lottos;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static step3.constant.Constant.Common.*;

public class LottoResultTest {
    private LottoResult lottoResult;
    private int purchasedCount;

    @BeforeEach
    void initRules() {
        new WinnerRule().setWinnerRules();
        lottoResult = new LottoResult();
        purchasedCount = 0;
    }

    @DisplayName("노보너스_최종_우승_금액_테스트")
    @ParameterizedTest
    @CsvSource(value = {"3-false,1-false,3-false,4-false,0-false:60000",
            "0-false,3-false,3-false,3-false,1-false,1-false:15000"}, delimiter = ':')
    void 노보너스_최종_우승_금액_테스트(String input, String expected) {
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

    @DisplayName("보너스_수익률_계산_테스트")
    @ParameterizedTest
    @CsvSource(value = {"1-false,0-false,2-false,5-false:375.0",
            "0-false,0-false,1-false,5-true:7500.0",
            "3-false,1-false,1-false,5-true:7501.25"}, delimiter = ':')
    void 보너스_수익률_계산_테스트(String input, String expected) {
        makeResult(input);
        lottoResult.calculateProfitRate(purchasedCount);
        assertEquals(expected, Double.toString(lottoResult.getProfitRate()));
    }


//    @DisplayName("수동_로또_생성_테스트")
//    @ParameterizedTest
//    @CsvSource(value = {"1-1|1,2,3,4,5,6-:1,2,3,4,5,6|",
//            "2-2|1,2,3,4,5,6-7,8,9,10,11,12:1,2,3,4,5,6|7,8,9,10,11,12"}, delimiter = ':')
//    void 수동_로또_생성_테스트(String input, String expected) {
//        Lottos resultLottos = makeReultLotto(expected);
//
//
//        String[] inputArr = input.split(SPLIT_BAR)[0].split(BAR);
//        lottoGenerator.setPurchasePriceAndManualCount(inputArr[0], inputArr[1]);
//
//        String[] manualNumberArr = input.split(SPLIT_BAR)[1].split(BAR);
//        for(String m : manualNumberArr) {
//            lottoGenerator.addLottos();
//        }
//
//
//        lottoResult.calculateProfitRate(purchasedCount);
//        assertEquals(expected, Double.toString(lottoResult.getProfitRate()));
//    }
//
//    private Lottos makeReultLotto(String expected) {
//        String[] expectedStrArr = expected.split(SPLIT_BAR);
//        List<Lotto> resultLottos = new ArrayList<>();
//
//        for(String s : expectedStrArr) {
//            Lotto lotto = new Lotto(s.split(COMMA));
//            resultLottos.add(lotto);
//        }
//        return new Lottos(resultLottos);
//    }

    private void makeResult(String input) {
        String[] inputArr = input.split(COLON)[0].split(COMMA);
        for (String s : inputArr) {
            String[] detail = s.split(BAR);
            lottoResult.addResult(Integer.parseInt(detail[0]), detail[1].equals("true"));
            purchasedCount++;
        }
    }
}
