package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.constant.WinnerRule;
import step3.model.Lotto;
import step3.model.LottoGenerator;
import step3.model.LottoResult;
import step3.model.Lottos;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
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


    @DisplayName("수동_로또_생성_테스트")
    @Test
    void 수동_로또_생성_테스트() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        lottoGenerator.setPurchasePriceAndManualCount("3000", "1");
        lottoGenerator.calculatePurchaseCount();

        String[] temp = "1,2,3,4,5,6".split(COMMA);
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto(temp);
        lottos.add(lotto);

        List<Lotto> manualLottos = lottos;
        List<Lotto> autoLottos = lottoGenerator.generateAutoLottos();

        lottoGenerator.mergeManualAndAuto(manualLottos, autoLottos);

        assertAll(
                () -> Assertions.assertThat(lottoGenerator.getLottos().lottos.size()).isEqualTo(3),
                () -> Assertions.assertThat(lottoGenerator.getLottos().getLottoList()).contains(lottos.get(0))

        );
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
